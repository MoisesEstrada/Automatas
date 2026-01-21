import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router'; // <--- NUEVO: Para la redirección
import { Observable, tap } from 'rxjs';

const API_URL = 'http://localhost:8080/api';

export interface LoginResponse {
  id: number;
  username: string;
  email: string;
  role: string;
  token: string;
  type: string;
}

@Injectable({ providedIn: 'root' })
export class AuthService {
  private user: { id: number; username: string; role: string } | null = null;

  constructor(
    private http: HttpClient,
    private router: Router // <--- NUEVO: Inyectamos el router
  ) {
    const stored = localStorage.getItem('user');
    if (stored && stored !== 'undefined') {
      try {
        this.user = JSON.parse(stored);
      } catch (e) {
        console.warn('localStorage "user" corrupted, resetting.');
        this.logout(); // Usamos logout para limpiar todo si hay error
      }
    }
  }

  login(credentials: { username: string; password: string }): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(`${API_URL}/auth/login`, credentials).pipe(
      tap(response => {
        // Guardamos el token de forma segura
        localStorage.setItem('auth_token', response.token);

        const userData = {
          id: response.id,
          username: response.username,
          role: response.role
        };

        localStorage.setItem('user', JSON.stringify(userData));
        this.user = userData;
      })
    );
  }

  getUser(): { id: number; username: string; role: string } | null {
    return this.user;
  }

  getToken(): string | null {
    return localStorage.getItem('auth_token');
  }

  // ==========================================
  // ARREGLO: LOGOUT CON REDIRECCIÓN A PORTADA
  // ==========================================
  logout(): void {
    // 1. Limpiamos datos locales
    localStorage.removeItem('auth_token');
    localStorage.removeItem('user');
    localStorage.clear(); // Limpieza profunda por si acaso

    // 2. Reseteamos el estado interno
    this.user = null;

    // 3. REDIRECCIÓN AL INICIO (Portada / Landing Page)
    // Esto asegura que al salir del panel Docente/Admin/Estudiante
    // termine en la raíz ''
    this.router.navigate(['/']);
  }
}

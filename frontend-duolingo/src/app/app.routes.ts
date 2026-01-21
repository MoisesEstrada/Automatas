import { Routes } from '@angular/router';

// Guards
import { authGuard } from './guards/auth-guard';
import { roleGuard } from './guards/role-guard';

export const routes: Routes = [
  // =========================
  // RUTAS PÚBLICAS
  // =========================
  {
    path: '',
    loadComponent: () => import('./components/landing-page/landing-page').then(m => m.LandingPageComponent)
  },
  {
    path: 'roles',
    loadComponent: () => import('./modules/auth/role-selection/role-selection').then(m => m.RoleSelectionComponent)
  },
  {
    path: 'login',
    loadComponent: () => import('./modules/auth/login/login').then(m => m.LoginComponent)
  },

  // =========================
  // ADMIN
  // =========================
  {
    path: 'admin',
    canActivate: [authGuard, roleGuard],
    data: { roles: ['ADMIN'] },
    children: [
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' }, // Redirige /admin a /admin/dashboard
      {
        path: 'dashboard',
        loadComponent: () => import('./modules/admin/dashboard/dashboard').then(m => m.DashboardComponent)
      },
      {
        path: 'users',
        loadComponent: () => import('./modules/admin/users/users').then(m => m.UsersComponent)
      }
    ]
  },

  // =========================
  // DOCENTE
  // =========================
  {
    path: 'teacher',
    canActivate: [authGuard, roleGuard],
    data: { roles: ['DOCENTE'] },
    children: [
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
      {
        path: 'dashboard',
        loadComponent: () => import('./modules/teacher/dashboard/dashboard').then(m => m.DashboardComponent)
      },
      {
        path: 'create-round',
        loadComponent: () => import('./modules/teacher/create-round/create-round').then(m => m.CreateRoundComponent)
      },
      {
        path: 'edit-round/:id',
        loadComponent: () => import('./modules/teacher/create-round/create-round').then(m => m.CreateRoundComponent)
      }
    ]
  },

  // =========================
  // ESTUDIANTE
  // =========================
  {
    path: 'student',
    canActivate: [authGuard, roleGuard],
    data: { roles: ['ESTUDIANTE'] },
    children: [
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
      {
        path: 'dashboard',
        loadComponent: () => import('./modules/student/dashboard/dashboard').then(m => m.DashboardComponent)
      },
      {
        path: 'practice/:id',
        loadComponent: () => import('./modules/student/practice/practice').then(m => m.PracticeComponent)
      }
    ]
  },

  // =========================
  // FALLBACK (Cualquier ruta inválida vuelve al inicio)
  // =========================
  { path: '**', redirectTo: '' }
];

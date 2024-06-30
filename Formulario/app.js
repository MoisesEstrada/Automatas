const regexPatterns = {
    username: /^[a-zA-Z0-9_]{5,20}$/,
    email: /^[^\s@]+@[^\s@]+\.[^\s@]+$/,
    password: /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,15}/,
    phone: /^[0-9]{9}$/
};

document.addEventListener('DOMContentLoaded', function() {
    
    function validateField(input, regex) {
        return regex.test(input.value);
    }

    function showError(input, message) {
        const formControl = input.parentElement;
        const errorDiv = formControl.querySelector('.error-message');
        errorDiv.textContent = message;
        formControl.classList.add('error');
    }

    function showSuccess(input) {
        const formControl = input.parentElement;
        formControl.classList.remove('error');
        const errorDiv = formControl.querySelector('.error-message');
        errorDiv.textContent = '';
    }

    const loginForm = document.getElementById('loginForm');
    if (loginForm) {
        loginForm.addEventListener('submit', function(event) {
            event.preventDefault();

            const username = document.getElementById('loginUsername');
            const password = document.getElementById('loginPassword');

            if (username.value.trim() === '') {
                showError(username, 'El nombre de usuario es requerido.');
            } else if (!validateField(username, regexPatterns.username)) {
                showError(username, 'El nombre de usuario debe contener de 5 a 20 caracteres alfanuméricos y guión bajo.');
            } else {
                showSuccess(username);
            }

            if (password.value.trim() === '') {
                showError(password, 'La contraseña es requerida.');
            } else if (!validateField(password, regexPatterns.password)) {
                showError(password, 'La contraseña debe contener al menos 8 caracteres, una letra mayúscula, una letra minúscula y un dígito.');
            } else {
                showSuccess(password);
            }

            if (validateField(username, regexPatterns.username) && validateField(password, regexPatterns.password)) {
                window.location.href = 'usuario.html';
            }
        });
    }

    const registerForm = document.getElementById('registerForm');
    if (registerForm) {
        registerForm.addEventListener('submit', function(event) {
            event.preventDefault();

            const name = document.getElementById('registerName');
            const lastName = document.getElementById('registerLastName');
            const email = document.getElementById('registerEmail');
            const password = document.getElementById('registerPassword');

            if (name.value.trim() === '') {
                showError(name, 'El nombre es requerido.');
            } else {
                showSuccess(name);
            }

            if (lastName.value.trim() === '') {
                showError(lastName, 'Los apellidos son requeridos.');
            } else {
                showSuccess(lastName);
            }

            if (email.value.trim() === '') {
                showError(email, 'El email es requerido.');
            } else if (!validateField(email, regexPatterns.email)) {
                showError(email, 'Email inválido.');
            } else {
                showSuccess(email);
            }

            if (password.value.trim() === '') {
                showError(password, 'La contraseña es requerida.');
            } else if (!validateField(password, regexPatterns.password)) {
                showError(password, 'La contraseña debe contener al menos 8 caracteres, una letra mayúscula, una letra minúscula y un dígito.');
            } else {
                showSuccess(password);
            }


            if (
                validateField(email, regexPatterns.email) &&
                validateField(password, regexPatterns.password)
            ) 
            {
                localStorage.setItem('registeredEmail', email.value);
                localStorage.setItem('registeredPassword', password.value);

                window.location.href = 'login.html';
            }
        });
    }

    const userForm = document.getElementById('userForm');
    if (userForm) {
        userForm.addEventListener('submit', function(event) {
            event.preventDefault();

            const userName = document.getElementById('userName');
            const userAddress = document.getElementById('userAddress');
            const userPhone = document.getElementById('userPhone');
            const userEmail = document.getElementById('userEmail');
            const userSex = document.getElementById('userSex');
            const userAge = document.getElementById('userAge');

            if (userName.value.trim() === '') {
                showError(userName, 'El nombre es requerido.');
            } else {
                showSuccess(userName);
            }

            if (userAddress.value.trim() === '') {
                showError(userAddress, 'La dirección es requerida.');
            } else {
                showSuccess(userAddress);
            }

            if (userPhone.value.trim() === '') {
                showError(userPhone, 'El teléfono es requerido.');
            } else if (!validateField(userPhone, regexPatterns.phone)) {
                showError(userPhone, 'El teléfono debe contener 9 dígitos.');
            } else {
                showSuccess(userPhone);
            }

            if (userEmail.value.trim() === '') {
                showError(userEmail, 'El email es requerido.');
            } else if (!validateField(userEmail, regexPatterns.email)) {
                showError(userEmail, 'Email inválido.');
            } else {
                showSuccess(userEmail);
            }

            if (userSex.value === '') {
                showError(userSex, 'El sexo es requerido.');
            } else {
                showSuccess(userSex);
            }

            if (userAge.value.trim() === '') {
                showError(userAge, 'La edad es requerida.');
            } else if (userAge.value < 18 || userAge.value > 100) {
                showError(userAge, 'La edad debe estar entre 18 y 100 años.');
            } else {
                showSuccess(userAge);
            }

            if (
                validateField(userEmail, regexPatterns.email) &&
                validateField(userPhone, regexPatterns.phone)
            ) {
                console.log('Formulario de usuario enviado con éxito.');
            }
        });
    }
});

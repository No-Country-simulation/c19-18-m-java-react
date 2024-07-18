import React from 'react';
import logo from '../assets/logo.svg';

const Login = () => {
  return (
    <div className="flex items-center justify-center min-h-screen bg-gray-100">
      <div className="w-full max-w-md p-8 space-y-6 bg-white rounded-lg shadow-md">
        <div className="flex justify-center">
          <img src={logo} alt="Logo" className="w-24 h-24" />
        </div>
        <form className="space-y-4">
          <div>
            <label className="block text-sm font-medium text-gray-700">Correo electrónico</label>
            <input type="email" className="w-full px-3 py-2 mt-1 border border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500" />
          </div>
          <div>
            <label className="block text-sm font-medium text-gray-700">Password</label>
            <input type="password" className="w-full px-3 py-2 mt-1 border border-gray-300 rounded-md shadow-sm focus:ring-indigo-500 focus:border-indigo-500" />
          </div>
          <div className="flex space-x-2">
            <button type="submit" className="w-full px-4 py-2 text-white bg-red-500 rounded-md">Registrarse</button>
            <button type="button" className="w-full px-4 py-2 text-white bg-red-500 rounded-md">Ingresar como invitado</button>
          </div>
        </form>
        <div className="flex justify-center space-x-2">
          <button className="flex items-center px-4 py-2 bg-blue-500 rounded-md">
            <i className="fab fa-facebook-f text-white"></i>
          </button>
          <button className="flex items-center px-4 py-2 bg-red-500 rounded-md">
            <i className="fab fa-google text-white"></i>
          </button>
          <button className="flex items-center px-4 py-2 bg-black rounded-md">
            <i className="fab fa-apple text-white"></i>
          </button>
        </div>
        <div className="text-center">
          <p className="text-sm text-gray-600">
            ¿Ya tienes una cuenta? <a href="#" className="text-red-500">Ingresa aquí</a>
          </p>
          <p className="mt-2 text-xs text-gray-500">
            Al crear una cuenta aceptas los <a href="#" className="underline">Términos y condiciones</a> y <a href="#" className="underline">Política de Privacidad</a>
          </p>
        </div>
      </div>
    </div>
  );
};

export default Login;

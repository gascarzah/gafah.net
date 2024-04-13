
import { createBrowserRouter } from 'react-router-dom'
import Login from '../pages/Login';
import Internet from '../pages/noticias/Internet';
import Tv from '../pages/noticias/Tv';
import Prensa from '../pages/noticias/Prensa';
import DashboardLayout from '../layouts/DashboardLayout';
import { Root } from '../Root';
import AuthLayout from '../layouts/AuthLayout';
import Dashboard from '../pages/noticias/Dashboard';
import ListaPrensa from '../pages/noticias/ListaPrensa';
import EnvioCliente from '../pages/noticias/EnvioCliente';

export const router = createBrowserRouter( [
    {
      path: '/',
      element: <Root />,
      children: [
        /// Dashboard Routes
        {
          path: 'dashboard',
          element: <DashboardLayout />,
          children: [
            {
              path: '',
              element: <Dashboard />
            },
            {
              path: 'lista-prensa',
              element: <ListaPrensa />
            },
            {
              path: 'internet',
              element: <Internet />
            },
            {
              path: 'tv',
              element: <Tv />
            },
            {
              path: 'prensa',
              element: <Prensa />
            },
            {
              path: 'envio-cliente',
              element: <EnvioCliente />
            },
           
  
          ]
        },
  
        /// Auth Routes
        {
          path: 'auth',
          element: <AuthLayout />,
          children: [
            {
              path: 'login',
              element: <Login />
            }
          ]
  
        },
  
      ],
    },
  ] );
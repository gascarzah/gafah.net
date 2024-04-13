
import { Navbar } from '@/components'
import './globals.css'
import { Inter } from 'next/font/google'
import { Provider } from "react-redux";
import { store } from '../redux/store';

const inter = Inter({ subsets: ['latin'] })

export const metadata = {
  title: 'Portfolio Giovanni Ascarza',
  description: 'Mi portfolio',
}

export default function RootLayout({
  children,
}: {
  children: React.ReactNode
}) {



  return (
    <html lang="es">
      <body className={inter.className}>
        <Provider store={store}>
          <Navbar />


          {children}

        </Provider>
      </body>
    </html>
  )
}

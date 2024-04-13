
import Image from 'next/image'
import { Inter } from 'next/font/google'

import { Main, Projects, Contact, About } from '@/components'
import { useSelector } from "react-redux";



const inter = Inter({ subsets: ['latin'] })

export default  function Home() {
  
  const lenguaje = 'es'
  var language;
  // const languageglobal = useSelector((state) => state.language.type);
  // if (languageglobal === "ES") {
  //   language = { ...ES };
  // } else {
  //   language = { ...EN };
  // }
  return (
    <>
    
         <Main />
         {/* <h1> {es.page.about.title} </h1> */}
    <About />
    {/* <Skills /> */}
    <Projects />
    <Contact />
    </>
  )
}

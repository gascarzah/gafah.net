import React, { useEffect, useState } from 'react';
import Image from 'next/image';
import Link from 'next/link';


interface Props {
  lenguaje: string
}
export const About = () => {

  // const [lang, setLang] = useState({})



  return (
    <div id='about' className='w-full md:h-screen p-2 flex items-center py-16'>
      <div className='max-w-[1240px] m-auto md:grid grid-cols-3 gap-8'>
        <div className='col-span-2'>
          <p className='uppercase text-xl tracking-widest text-[#5651e5]'>
          About
          </p>
          <h2 className='py-4'>Who I Am</h2>
          <p className='py-2 text-gray-600'>
            I specialize in building mobile responsive front-end UI applications
            that connect with API’s and other backend technologies. I’m
            passionate about learning new technologies and understand there is
            more than one way to accomplish a task. Though I am most proficient
            in building front-end applications using HTML, CSS, Javascript, and
            React, I am a quick learner and can pick up new tech stacks as
            needed. I believe that being a great developer is not using one
            specific language, but choosing the best tool for the job.
          </p>
          <p className='py-2 text-gray-600'>
            I started web developement in 2013 managing multiple e-commerce
            websites on CMS platforms such as WordPress, BigCommerce, and
            Shopify. I have experience working directly with clients and taking
            mock wireframes all the way to deployed applications. In my spare
            time I run Code Commerce, a Youtube channel where I teach web
            developement and various front-end technologies.
          </p>
          <p className='py-2 text-gray-600'>
          Tengo experiencia desarrollando sistemas empresariales a medida desde la concepción hasta la puesta en producción sobre tecnología JEE (Java enterprise edition), trabajando en equipo y autónomamente, cuento con 17 años de experiencia, también en los últimos 5 años me he desempeñado como fullstack, tanto en la parte de backend como en frontend, me considero una persona proactiva, con capacidad de análisis para la solución de problemas.
          </p>
          <Link href='/#projects' className='py-2 text-gray-600 underline cursor-pointer'>

            Check out some of my latest projects.

          </Link>
        </div>
        <div className='w-full h-auto m-auto shadow-xl shadow-gray-400 rounded-xl flex items-center justify-center p-4 hover:scale-105 ease-in duration-300'>
          <Image src={'/assets/about.jpg'} className='rounded-xl' alt='/' width={700} height={700} />
        </div>
      </div>
    </div>
  );
};



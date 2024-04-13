import Image from 'next/image';
import Link from 'next/link';
import React from 'react';
import { ProjectItem } from './ProjectItem';

const projects = [
  {
    title: 'Property Finder',
    image: 'property',
    projectUrl: '/property',
    tech: 'React JS'
  },
  {
    title: 'Crypto App',
    image: 'crypto',
    projectUrl: '/crypto',
    tech: 'React JS'
  },
  {
    title: 'Netflix App',
    image: 'netflix',
    projectUrl: '/netflix',
    tech: 'React JS'
  },
  {
    title: 'Twitch UI',
    image: 'twitch',
    projectUrl: '/twitch',
    tech: 'Next JS'
  },
]




export const Projects = () => {
  return (
    <div id='projects' className='w-full'>
      <div className='max-w-[1240px] mx-auto px-2 py-16'>
        <p className='text-xl tracking-widest uppercase text-[#5651e5]'>
          Projects
        </p>
        <h2 className='py-4'>What I&apos;ve Built</h2>
        <div className='grid md:grid-cols-2 gap-8'>
          {projects.map((item, index) => (
            <ProjectItem key={item.title}
              title={item.title}
              backgroundImg={`/assets/projects/${item.image}.jpg`}
              projectUrl={item.projectUrl}
              tech={item.tech}
            />
          ))}

        </div>
      </div>
    </div>
  );
};


import React, { useState } from "react";
import Exalumnos from "../../data";
import {
  Button,
  Dialog,
  DialogContent,
  DialogTitle,
  
} from "@mui/material";

const Tarjeta = () => {
  const [scroll, setScroll] = useState('paper');
  const [modalInsertar, setModalInsertar]= useState(false);
  const exalumnos = Exalumnos;

  const handleOpen  = (row) => {
     setModalInsertar(true)
   }

  const cerrarModalInsertar = () => {
    setModalInsertar(false)
  }


  return (
    <>
      <h1 className="title">Integrantes de la Promocion 1998 - Santa Rosa de Chosica</h1>

      <div className="container">
        {exalumnos.map((exalumno, index) => {
          return (
            <div className="profile-card-1" key={index}>
              {/* <!--image--> */}
              <div className="img">
                <img src={exalumno.foto ? exalumno.foto : "default.jpg" } alt={exalumno.nombre}/>
              </div>
              {/* <a className="view-more" href="#"  onClick={() => handleOpen(exalumno)}>
                <i className="fa fa-plus-circle"></i>
              </a> */}

              {/* <Button size='small' color="primary" 
                  onClick={() => handleOpen(exalumno)}>
                     <i className="fa fa-plus-circle"></i>
                    </Button> */}

              {/* <!--text--> */}
              <div className="mid-section">
                <div className="name">{exalumno.nombre}</div>
                <div className="description">{exalumno.descripcion}</div>

                <div className="line"></div>
                {/* <div className="stats">
                <div className="stat">
                  53.4M
                  <div className="subtext">Followers</div>
                </div>
                <div className="stat">
                  324K
                  <div className="subtext">Liks</div>
                </div>
                <div className="stat">
                  236K
                  <div className="subtext">Shares</div>
                </div>
              </div> */}
              </div>
              {/* <!--social icons--> */}
              <div className="links">
                <a className={exalumno.classparentlogo1} href={exalumno.linklogo1} target="_blank" rel="noopener noreferrer">
                  <i className={exalumno.classlogo1} aria-hidden="true"></i>
                </a>
                <a className={exalumno.classparentlogo2} href={exalumno.linklogo2} target="_blank" rel="noopener noreferrer">
                  <i className={exalumno.classlogo2} aria-hidden="true"></i>
                </a>
                <a className={exalumno.classparentlogo3} href={exalumno.linklogo3} target="_blank" rel="noopener noreferrer">
                <i className={exalumno.classlogo3} aria-hidden="true"></i>
                </a>
                <a className={exalumno.classparentlogo4} href={exalumno.linklogo4} target="_blank" rel="noopener noreferrer">
                  <i className={exalumno.classlogo4} aria-hidden="true" ></i>
                </a>
              </div>
            </div>
          );
        })}
      </div>
       <footer className="footer">
        <p className="footer__title">Hecho por <a href="https://gascarzah.com" target={"_blank"}> Giovanni Ascarza</a> 2022</p>
        {/* <div className="footer__social">
            <a href="#" className="footer__icon"><i className='fa fa-facebook'></i></a>
            <a href="#" className="footer__icon"><i className='bx bxl-instagram'></i></a>
            <a href="#" className="footer__icon"><i className='bx bxl-twitter'></i></a>
        </div> */}
        {/* <p>&#169; 2022 todos los izquierdos reservados</p> */}
    </footer>

<Dialog  open={modalInsertar}
        onClose={cerrarModalInsertar}
        scroll={scroll}>
        <DialogTitle>Insertar</DialogTitle>
        <DialogContent dividers={scroll === 'paper'}>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Molestias consectetur tempore reiciendis recusandae, accusamus esse quam sed, dolores non in eius laborum repellat? Necessitatibus eaque corrupti assumenda iusto, odio earum.</p>
         </DialogContent>
        {/* <DialogActions>
          <Button onClick={cerrarModalInsertar}>Cancel</Button>
          <Button onClick={cerrarModalInsertar}>Subscribe</Button>
        </DialogActions> */}
      </Dialog>



    </>
  );
};

export default Tarjeta;

import Tarjeta from "./views/Tarjeta";
import "font-awesome/css/font-awesome.min.css";
import "./styles/profile.css";
import { Helmet } from "react-helmet";
function App() {
  return (
    <>
      <header>
        <Helmet>
          <meta charSet="utf-8" />

          <title>Promocion 1998 - Santa Rosa de Chosica</title>
          <meta
            name="description"
            content="promocion 1998 Santa Rosa de Chosica"
          />
          <link rel="icon" href="/favicon.ico" />
        </Helmet>
      </header>
      <Tarjeta />
    </>
  );
}

export default App;

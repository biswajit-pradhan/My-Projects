import { BrowserRouter, Route, Routes } from "react-router-dom";
import Formatter from "./Formatter";

const App = () => {
  return (
    <>
      <BrowserRouter>
        <div className="bg">
          <Routes>
            <Route path="/" element={<Formatter />} />
          </Routes>
        </div>
      </BrowserRouter>
    </>
  );
};

export default App;

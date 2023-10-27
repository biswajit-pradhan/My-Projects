import processingGif from "./Images/processingGif.gif";
import React from "react";

const Processing = () => {
  return (
    <div className="centered-gif-container">
      <img src={processingGif} alt="Centered GIF" className="centered-gif" />
    </div>
  );
};

export default Processing;

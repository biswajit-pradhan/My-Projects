import React, { useState, useEffect } from "react";

const Timer = () => {
  const [seconds, setSeconds] = useState(120);
  const [isTimerVisible, setTimerVisible] = useState(true);

  useEffect(() => {
    const countdown = setInterval(() => {
      if (seconds > 0) {
        setSeconds(seconds - 1);
      }
    }, 1000);

    if (seconds === 0) {
      clearInterval(countdown);
      setTimerVisible(false);
    }

    // Clean up the interval when the component unmounts
    return () => clearInterval(countdown);
  }, [seconds]);

  const formattedTime = `${String(Math.floor(seconds / 60)).padStart(
    2,
    "0"
  )}:${String(seconds % 60).padStart(2, "0")}`;

  return isTimerVisible ? (
    <>
      <p>{formattedTime}</p>
      <h6 style={{ color: "green" }}>
        OTP has been sent to your mail.Please check!!
      </h6>
    </>
  ) : null;
};

export default Timer;

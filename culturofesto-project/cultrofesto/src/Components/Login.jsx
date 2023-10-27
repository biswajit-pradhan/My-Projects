import React, { useState } from "react";
import axios from "axios";
import { NavLink, useNavigate } from "react-router-dom";
// import "./style.css";

function Login() {
  const [user, setUser] = useState({
    userName: "",
    password: "",
  });
  const [errors, setErrors] = useState({});
  const [msg, setMsg] = useState("");
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const changeHandler = (event) => {
    setUser({
      ...user,
      [event.target.name]: event.target.value,
    });
  };

  const handleValidation = () => {
    const userNamePattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    let tempErrors = {};
    let formValid = true;

    if (!user.userName) {
      formValid = false;
      tempErrors["userName"] = "userName cannot be empty";
    } else if (!userNamePattern.test(user.userName)) {
      formValid = false;
      tempErrors["userName"] = "UserName not valid";
    }

    if (!user.password) {
      formValid = false;
      tempErrors["password"] = "Password cannot be empty";
    }

    setErrors(tempErrors);
    return formValid;
  };

  const loginUser = async () => {
    if (handleValidation()){

    
    // let authCode = "Basic " + btoa(user.userName + ":" + user.password);
    // try {
    //   const response = await axios.get("http://localhost:8080/api/user/login", {
    //     headers: { Authorization: authCode },
    //   });
    //   const data = response.data;
    //   console.log("login success " + data);
    //   localStorage.setItem("userName", data.userName);
    //   setIsLoggedIn(true);
    // } catch (error) {
    //   console.error(error);
    //   setMsg("Invalid Credentials");
    // }
    }
  };

  const navigate = useNavigate();
  const handleBack = () => {
    navigate(-1);
  };

  return isLoggedIn ? (
    <div>Home Component</div>
  ) : (
    <>
      <NavLink to="#" className="btn" onClick={handleBack}>
        🔙
      </NavLink>
      <div className="page_container">
        <div className="event-booking-container">
          <div id="login">
            <div className="container">
              <div
                id="login-row"
                className="row justify-content-center align-items-center"
              >
                <div id="login-column" className="col-md-6">
                  <div id="login-box" className="col-md-12">
                    <h3 className="text-center text-info homepage_upcoming_title">
                      Log in
                    </h3>
                    <span style={{ color: "red" }}>{msg}</span> <br />
                    <div className="form-group">
                      <label htmlFor="userName" className="text-info">
                        Email:
                      </label>
                      <br />
                      <input
                        className="form-control"
                        placeholder="Enetr Username"
                        name="userName"
                        value={user.userName}
                        onChange={changeHandler}
                      />
                      <span style={{ color: "red" }}>{errors["userName"]}</span>
                    </div>
                    <div className="form-group">
                      <label htmlFor="password" className="text-info">
                        Password:
                      </label>
                      <br />
                      <input
                        type="password"
                        className="form-control"
                        placeholder="Enetr Password"
                        name="password"
                        value={user.password}
                        onChange={changeHandler}
                      />
                      <span style={{ color: "red" }}>{errors["password"]}</span>
                    </div>
                    <div className="form-group">
                      <br />
                      <div
                        style={{ alignItems: "center", textAlign: "center" }}
                      >
                        <button
                          className="btn btn-info btn-md"
                          onClick={loginUser}
                        >
                          Login
                        </button>
                        <br />
                        <br />
                        <NavLink
                          to="/signup"
                          className="text-info"
                          style={{ textDecoration: "none" }}
                        >
                          Dont have a account, Register Here!!
                        </NavLink>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <br />
      <br />
      <br />
      <br />
      <br />
    </>
  );
}

export default Login;

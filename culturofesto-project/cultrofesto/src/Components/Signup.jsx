import { useState } from "react";
import axios from "axios";
import { NavLink, useNavigate } from "react-router-dom";

const SignUp = () => {
  const navigate = useNavigate();
  const handleBack = () => {
    navigate(-1);
  };

  const [userSignUp, setUserSignUp] = useState({
    userName: "",
    emailId: "",
    userrole: "",
    password: "",
  });
  const [errors, setErrors] = useState({});
  const [msg, setMsg] = useState("");

  const changeHandler = (event) => {
    setUserSignUp({
      ...userSignUp,
      [event.target.name]: event.target.value,
    });
  };

  const handleValidation = () => {
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    const namePattern = /^[a-zA-Z.'\s]{2,25}$/;
    const passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,}$/;
    let tempErrors = {};
    let formValid = true;

    if (!userSignUp.userName) {
      formValid = false;
      tempErrors["userName"] = "Name cannot be empty";
    } else if (!namePattern.test(userSignUp.userName)) {
      formValid = false;
      tempErrors["userName"] =
        "Name must be at least 2 and maximum 25 characters";
    }
    if (!userSignUp.emailId) {
      formValid = false;
      tempErrors["emailId"] = "Email cannot be empty";
    } else if (!emailPattern.test(userSignUp.emailId)) {
      formValid = false;
      tempErrors["emailId"] = "Email not valid";
    }
    if (!userSignUp.password) {
      formValid = false;
      tempErrors["password"] = "Password cannot be empty";
    } else if (!passwordPattern.test(userSignUp.password)) {
      formValid = false;
      tempErrors["password"] =
        "Password must contain 8 characters, one uppercase character, and one capital letter";
    }

    setErrors(tempErrors);
    return formValid;
  };

  const postUser = async (userSignUp) => {
    // try {
    //   const response = await axios.post(
    //     "http://localhost:8080/api/user/signUp",
    //     userSignUp
    //   );
    //   const data = response.data;
    //   console.log("API success");
    //   console.log(data);
    //   setMsg("User Added");
    // } catch (error) {
    //   console.log(error.response.data.msg);
    //   setMsg("Operation Failed");
    // }

    handleBack();
  };

  const onSignUp = () => {
    if (handleValidation()) {
      postUser(userSignUp);
    } else {
      console.log("Validation not passed..");
    }
  };

  return (
    <>
      <NavLink to="#" className="btn" onClick={handleBack}>
        🔙
      </NavLink>
      <div className="page_container">
        <div className="event-booking-container">
          <div id="signup">
            <div className="container">
              <div
                id="signup-row"
                className="row justify-content-center align-items-center"
              >
                <div id="signup-column" className="col-md-6">
                  <div id="signup-box" className="col-md-12">
                    <h3 className="text-center text-info homepage_upcoming_title">
                      Sign Up
                    </h3>
                    <section>
                      <div className="form-group">
                        <label htmlFor="name" className="text-info">
                          Name:
                        </label>
                        <br />
                        <input
                          type="text"
                          name="userName"
                          id="name"
                          className="form-control"
                          value={userSignUp.userName}
                          onChange={changeHandler}
                        />
                        <span style={{ color: "red" }}>
                          {errors["userName"]}
                        </span>
                      </div>
                      <div className="form-group">
                        <label htmlFor="username" className="text-info">
                          Email:
                        </label>
                        <br />
                        <input
                          type="text"
                          name="emailId"
                          id="username"
                          className="form-control"
                          value={userSignUp.emailId}
                          onChange={changeHandler}
                        />
                        <span style={{ color: "red" }}>
                          {errors["emailId"]}
                        </span>
                      </div>
                      <label htmlFor="userrole" className="text-info">
                        Select User Type:
                      </label>
                      <br />
                      <select
                        className="form-control"
                        name="userrole"
                        value={userSignUp.userrole}
                        onChange={changeHandler}
                      >
                        <option key={0} value="">
                          --SELECT USER--
                        </option>
                        <option key={1} value="Admin">
                          Admin
                        </option>

                        <option key={2} value="User">
                          User
                        </option>
                      </select>
                      <div className="form-group">
                        <label htmlFor="password" className="text-info">
                          Password:
                        </label>
                        <br />
                        <input
                          type="text"
                          name="password"
                          id="password"
                          className="form-control"
                          value={userSignUp.password}
                          onChange={changeHandler}
                        />
                        <span style={{ color: "red" }}>
                          {errors["password"]}
                        </span>
                      </div>
                      <span style={{ color: "green" }}>{msg}</span> <br />
                      <div className="form-group">
                        <br />
                        <button
                          className="btn btn-primary btn-lg"
                          type="submit"
                          value="SignUp"
                          onClick={onSignUp}
                        >
                          Sign Up
                        </button>
                      </div>
                    </section>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default SignUp;

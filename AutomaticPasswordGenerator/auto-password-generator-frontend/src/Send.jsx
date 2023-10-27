import axios from "axios";
import { useFormik } from "formik";
import { useState } from "react";
import * as Yup from "yup";

import Processing from "./Processing";
import Timer from "./Timer";

const initialValues = {
  firstName: "",
  lastName: "",
  email: "",
};

const validationSchema = Yup.object({
  firstName: Yup.string()
    .matches(
      /^[a-zA-Z][a-zA-Z\s]*$/,
      "First name should contain only alphabets"
    )
    .min(2)
    .max(25)
    .required("Please enter first name!!"),
  lastName: Yup.string()
    .matches(/^[a-zA-Z][a-zA-Z\s]*$/, "Last name should contain only alphabets")
    .min(2)
    .max(25)
    .required("Please enter last name!!"),
  email: Yup.string().email().required("Please enter email!!"),
});

const Send = () => {
  const [isLoading, setIsLoading] = useState(false);
  const [isSubmitted, setIsSubmitted] = useState(false);
  const {
    values,
    errors,
    touched,
    handleBlur,
    handleChange,
    handleSubmit,
    resetForm,
  } = useFormik({
    initialValues: initialValues,
    validationSchema: validationSchema,
    onSubmit: async (values) => {
      try {
        setIsLoading(true);
        const data = {
          firstName: values.firstName,
          to: values.email,
          times: 1,
        };
        const response = await axios.post("/sendOtp", null, {
          params: data,
        });
        setIsLoading(false);

        console.log("API Response:", response.data);
        if (response.data === "success") {
          setIsSubmitted(true);
          resetForm();
        } else {
          setTimeout(() => {
            alert(response.data);
          }, 100);
        }
      } catch (error) {
        setIsLoading(false);
        setTimeout(() => {
          alert(error);
        }, 100);
        console.error("API Request Error:", error);
      } finally {
        setIsLoading(false);
      }
    },
  });

  return (
    <>
      <div className="center_container">
        <div className="event-booking-container">
          <h3 className="text-center">AUTOMATIC PASSWORD GENERATOR</h3>
          <form
            onSubmit={(e) => {
              handleSubmit(e);
            }}
          >
            <div className="row">
              <div className="col-md-6">
                <div className="form-group">
                  <label htmlFor="eventName" className="form-label">
                    First Name
                  </label>
                  {errors.firstName && touched.firstName ? (
                    <p className="form_errors">{errors.firstName}</p>
                  ) : null}
                  <input
                    className="form-control"
                    type="text"
                    placeholder="Enter First Name"
                    id="firstName"
                    value={values.firstName}
                    onChange={handleChange}
                    onBlur={handleBlur}
                  />
                </div>
              </div>

              <div className="col-md-6">
                <div className="form-group">
                  <label htmlFor="eventDate" className="form-label">
                    Last Name
                  </label>
                  {errors.lastName && touched.lastName ? (
                    <p className="form_errors">{errors.lastName}</p>
                  ) : null}
                  <input
                    className="form-control"
                    type="text"
                    id="lastName"
                    placeholder="Enter Last Name"
                    value={values.lastName}
                    onChange={handleChange}
                    onBlur={handleBlur}
                  />
                </div>
              </div>

              <div className="col-md-12">
                <div className="form-group">
                  <label htmlFor="email" className="form-label">
                    Email
                  </label>
                  {errors.email && touched.email ? (
                    <p className="form_errors">{errors.email}</p>
                  ) : null}
                  <input
                    className="form-control"
                    type="text"
                    id="email"
                    placeholder="Enter Email"
                    value={values.email}
                    onChange={handleChange}
                    onBlur={handleBlur}
                  />
                </div>
              </div>
            </div>
            {isLoading && <Processing />}
            {isSubmitted ? (
              <>
                <div>
                  <div className="text-center" style={{ paddingTop: "10px" }}>
                    <Timer />
                  </div>
                </div>
              </>
            ) : null}
            <div className="text-center" style={{ paddingTop: "10px" }}>
              <button className="btn btn-primary" type="submit">
                Submit
              </button>
            </div>
          </form>
        </div>
      </div>
    </>
  );
};

export default Send;

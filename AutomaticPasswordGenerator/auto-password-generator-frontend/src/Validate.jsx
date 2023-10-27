import axios from "axios";
import { useFormik } from "formik";
import { useState } from "react";
import * as Yup from "yup";
import Processing from "./Processing";

const initialValues = {
  otp: "",
};

const validationSchema = Yup.object({
  otp: Yup.string().min(2).max(8).required("Please enter OTP!!"),
});

const Validate = () => {
  const [isLoading, setIsLoading] = useState(false);
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
    onSubmit: async (values, action) => {
      try {
        setIsLoading(true);
        const data = {
          otp: values.otp,
        };
        const response = await axios.get("/validateOtp", {
          params: data,
        });
        setIsLoading(false);
        console.log("API Response:", response.data);
        if (response.data === "User is Valid") {
          setTimeout(() => {
            alert(response.data);
          }, 100);
          resetForm();
        } else {
          setTimeout(() => {
            alert(response.data);
          }, 100);
        }
      } catch (error) {
        setIsLoading(false);
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
          <h3 className="text-center">PASSWORD VALIDATOR</h3>
          <form
            onSubmit={(e) => {
              handleSubmit(e);
            }}
          >
            <div className="row">
              <div className="col-md-12">
                <div className="form-group">
                  <label htmlFor="eventName" className="form-label">
                    OTP
                  </label>
                  {errors.otp && touched.otp ? (
                    <p className="form_errors">{errors.otp}</p>
                  ) : null}
                  <input
                    className="form-control"
                    type="text"
                    placeholder="Enter OTP"
                    id="otp"
                    value={values.otp}
                    onChange={handleChange}
                    onBlur={handleBlur}
                  />
                </div>
              </div>
            </div>
            {isLoading && <Processing />}
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

export default Validate;

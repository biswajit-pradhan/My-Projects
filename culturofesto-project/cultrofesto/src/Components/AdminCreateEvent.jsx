import axios from "axios";
import { useFormik } from "formik";
import { NavLink, useNavigate } from "react-router-dom";
import * as Yup from "yup";
import { useState } from "react";

const initialValues = {
  eventName: "",
  eventDate: "",
  registrationOpenDate: "",
  registrationCloseDate: "",
  eventStartTime: "",
  eventCloseTime: "",
  registrationFee: "",
  eventCapacity: "",
  breakfastPrice: "",
  lunchPrice: "",
  dinnerPrice: "",
  eventImage: null,
};

const validationSchema = Yup.object({
  eventName: Yup.string()
    .matches(
      /^[a-zA-Z][a-zA-Z\s]*$/,
      "Event name should contain only alphabets"
    )
    .min(2)
    .max(25)
    .required("Please set event name!!"),
  eventDate: Yup.string().required("Please set event date!!"),
  registrationOpenDate: Yup.string().required(
    "Please set registration open date!!"
  ),
  registrationCloseDate: Yup.string().required(
    "Please set registration open date!!"
  ),
  eventStartTime: Yup.string().required("Please set event start time!!"),
  eventCloseTime: Yup.string().required("Please set event close time!!"),
  registrationFee: Yup.string().required("Please set registration fee!!"),
  eventCapacity: Yup.string().required("Please set event capacity!!"),
  breakfastPrice: Yup.string().required("Please set breakfast price!!"),
  lunchPrice: Yup.string().required("Please set lunch price!!"),
  dinnerPrice: Yup.string().required("Please set dinner price!!"),
  eventImage: Yup.mixed().required("Please choose event image!!"),
});

const handleSubmitEvent = async (values, imageData) => {
  try {
    const formData = new FormData();
    const { eventImage, ...newValues } = values;
    newValues.deleteStatus = "false";
    newValues.eventStartTime += ":00";
    newValues.eventCloseTime += ":00";

    formData.append("event", JSON.stringify(newValues));
    formData.append("eventImage", imageData);

    const response = await axios.post("/api/admin/event/newevent", formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
    });

    if (response.ok) {
      console.log("Event added successfully");
    } else {
      const error = await response.text();
      console.log("Error:", error);
    }
  } catch (error) {
    console.log("Error:", error.message);
  }
};

const AdminCreateEvent = () => {
  const [imageData, setImageData] = useState(null);

  const handleImageUpload = (event) => {
    const file = event.target.files[0];
    setImageData(file);
    handleChange(event);
  };

  const { values, errors, touched, handleBlur, handleChange, handleSubmit } =
    useFormik({
      initialValues: initialValues,
      validationSchema: validationSchema,
      onSubmit: (values, action) => {
        console.log(values);
        handleSubmitEvent(values, imageData);
        alert("Event added successfully");
        handleBack();
      },
    });

  const navigate = useNavigate();
  const handleBack = () => {
    navigate(-1);
  };

  return (
    <>
      <NavLink to="#" onClick={handleBack} className="btn">
        🔙
      </NavLink>
      <div className="page_container">
        <div className="event-booking-container">
          <h1 className="text-center">Event Creation Form</h1>
          <form onSubmit={handleSubmit}>
            <div className="row">
              <div className="col-md-6">
                <div className="form-group">
                  <label htmlFor="eventName" className="form-label">
                    Event Name
                  </label>
                  {errors.eventName && touched.eventName ? (
                    <p className="form_errors">{errors.eventName}</p>
                  ) : null}
                  <input
                    className="form-control"
                    type="text"
                    placeholder="Enter event name"
                    id="eventName"
                    value={values.eventName}
                    onChange={handleChange}
                    onBlur={handleBlur}
                  />
                </div>
              </div>

              <div className="col-md-6">
                <div className="form-group">
                  <label htmlFor="eventDate" className="form-label">
                    Event Date
                  </label>
                  {errors.eventDate && touched.eventDate ? (
                    <p className="form_errors">{errors.eventDate}</p>
                  ) : null}
                  <input
                    className="form-control"
                    type="date"
                    id="eventDate"
                    value={values.eventDate}
                    onChange={handleChange}
                    onBlur={handleBlur}
                  />
                </div>
              </div>

              <div className="col-md-12">
                <div className="form-group">
                  <label htmlFor="registrationOpenDate" className="form-label">
                    Registration Open Date
                  </label>
                  {errors.registrationOpenDate &&
                  touched.registrationOpenDate ? (
                    <p className="form_errors">{errors.registrationOpenDate}</p>
                  ) : null}
                  <input
                    className="form-control"
                    type="date"
                    id="registrationOpenDate"
                    value={values.registrationOpenDate}
                    onChange={handleChange}
                    onBlur={handleBlur}
                  />
                </div>
              </div>
            </div>

            <div className="row">
              <div className="col-md-6">
                <div className="form-group">
                  <label htmlFor="registrationCloseDate" className="form-label">
                    Registration Close Date
                  </label>
                  {errors.registrationCloseDate &&
                  touched.registrationCloseDate ? (
                    <p className="form_errors">
                      {errors.registrationCloseDate}
                    </p>
                  ) : null}
                  <input
                    className="form-control"
                    type="date"
                    id="registrationCloseDate"
                    value={values.registrationCloseDate}
                    onChange={handleChange}
                    onBlur={handleBlur}
                  />
                </div>
              </div>

              <div className="col-md-6">
                <div className="form-group">
                  <label htmlFor="eventStartTime" className="form-label">
                    Event Start Time
                  </label>
                  {errors.eventStartTime && touched.eventStartTime ? (
                    <p className="form_errors">{errors.eventStartTime}</p>
                  ) : null}
                  <input
                    className="form-control"
                    type="time"
                    id="eventStartTime"
                    value={values.eventStartTime}
                    onChange={handleChange}
                    onBlur={handleBlur}
                  />
                </div>
              </div>
            </div>

            <div className="row">
              <div className="col-md-6">
                <div className="form-group">
                  <label htmlFor="eventCloseTime" className="form-label">
                    Event Close Time
                  </label>
                  {errors.eventCloseTime && touched.eventCloseTime ? (
                    <p className="form_errors">{errors.eventCloseTime}</p>
                  ) : null}
                  <input
                    className="form-control"
                    type="time"
                    id="eventCloseTime"
                    value={values.eventCloseTime}
                    onChange={handleChange}
                    onBlur={handleBlur}
                  />
                </div>
              </div>

              <div className="col-md-6">
                <div className="form-group">
                  <label htmlFor="registrationFee" className="form-label">
                    Registration Fee
                  </label>
                  {errors.registrationFee && touched.registrationFee ? (
                    <p className="form_errors">{errors.registrationFee}</p>
                  ) : null}
                  <input
                    className="form-control"
                    type="number"
                    step="0.01"
                    placeholder="Enter registration fee"
                    id="registrationFee"
                    value={values.registrationFee}
                    onChange={handleChange}
                    onBlur={handleBlur}
                  />
                </div>
              </div>
            </div>

            <div className="row">
              <div className="col-md-6">
                <div className="form-group">
                  <label htmlFor="eventCapacity" className="form-label">
                    Event Capacity
                  </label>
                  {errors.eventCapacity && touched.eventCapacity ? (
                    <p className="form_errors">{errors.eventCapacity}</p>
                  ) : null}
                  <input
                    className="form-control"
                    type="number"
                    step="1"
                    placeholder="Enter event capacity"
                    id="eventCapacity"
                    value={
                      /^[1-9]\d*$/.test(values.eventCapacity)
                        ? parseInt(values.eventCapacity)
                        : ""
                    }
                    onChange={handleChange}
                    onBlur={handleBlur}
                  />
                </div>
              </div>

              <div className="col-md-6">
                <div className="form-group">
                  <label htmlFor="breakfastPrice" className="form-label">
                    Breakfast Price
                  </label>
                  {errors.breakfastPrice && touched.breakfastPrice ? (
                    <p className="form_errors">{errors.breakfastPrice}</p>
                  ) : null}
                  <input
                    className="form-control"
                    type="number"
                    step="0.01"
                    placeholder="Enter breakfast price"
                    id="breakfastPrice"
                    value={values.breakfastPrice}
                    onChange={handleChange}
                    onBlur={handleBlur}
                  />
                </div>
              </div>
            </div>

            <div className="row">
              <div className="col-md-6">
                <div className="form-group">
                  <label htmlFor="lunchPrice" className="form-label">
                    Lunch Price
                  </label>
                  {errors.lunchPrice && touched.lunchPrice ? (
                    <p className="form_errors">{errors.lunchPrice}</p>
                  ) : null}
                  <input
                    className="form-control"
                    type="number"
                    step="0.01"
                    placeholder="Enter lunch price"
                    id="lunchPrice"
                    value={values.lunchPrice}
                    onChange={handleChange}
                    onBlur={handleBlur}
                  />
                </div>
              </div>

              <div className="col-md-6">
                <div className="form-group">
                  <label htmlFor="dinnerPrice" className="form-label">
                    Dinner Price
                  </label>
                  {errors.dinnerPrice && touched.dinnerPrice ? (
                    <p className="form_errors">{errors.dinnerPrice}</p>
                  ) : null}
                  <input
                    className="form-control"
                    type="number"
                    step="0.01"
                    placeholder="Enter dinner price"
                    id="dinnerPrice"
                    value={values.dinnerPrice}
                    onChange={handleChange}
                    onBlur={handleBlur}
                  />
                </div>
              </div>
            </div>

            <div className="form-group">
              <label htmlFor="eventImage" className="form-label">
                Event Image
              </label>
              {errors.eventImage && touched.eventImage ? (
                <p className="form_errors">{errors.eventImage}</p>
              ) : null}
              <input
                className="form-control"
                type="file"
                accept="image/*"
                name="eventImage"
                id="eventImage"
                onChange={handleImageUpload}
              />
            </div>

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

export default AdminCreateEvent;

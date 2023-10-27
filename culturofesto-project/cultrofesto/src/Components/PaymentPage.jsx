import React from "react";
import { NavLink, useNavigate, useParams } from "react-router-dom";
import { useFormik } from "formik";
import * as Yup from "yup";
import axios from "axios";

const PaymentPage = () => {
  const { bookingId, totalPrice } = useParams();
  console.log(bookingId, totalPrice);
  const navigate = useNavigate();

  const validationSchema = Yup.object().shape({
    paymentMethod: Yup.string().required("Payment Method is required"),
    cardNumber: Yup.string()
      .min(12)
      .max(12)
      .required("Card Number is required"),
    expiryDate: Yup.string().required("Expiry Date is required"),
    cvvNumber: Yup.string().min(3).max(3).required("CVV Number is required"),
    totalTicketPrice: Yup.number().required("Total Ticket Price is required"),
  });

  const formik = useFormik({
    initialValues: {
      bookingDataId: bookingId, // Placeholder for booking ID
      paymentMethod: "",
      cardNumber: "",
      expiryDate: "",
      cvvNumber: "",
      totalTicketPrice: totalPrice, // Placeholder for total price
    },
    validationSchema: validationSchema,
    onSubmit: (values) => {
      handlePayment(values);
    },
  });

  const handlePayment = (paymentData) => {
    console.log(paymentData);

    const bookingId = paymentData.bookingDataId; // Extract the bookingId from the paymentData object

    axios
      .post(`/api/booking/addpaymentdatabybookingid/${bookingId}`, paymentData)
      .then((response) => {
        console.log(response.data);
        alert(response.data);
        navigate("/");
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const handleBack = () => {
    navigate(-1);
  };

  return (
    <>
      <NavLink to="#" onClick={handleBack} className="btn back-link">
        <span className="back-link-icon">🔙</span>
      </NavLink>
      <div className="page_container" style={{ paddingTop: "20px" }}>
        <div className="event-booking-container">
          <div className="container">
            <h1 className="container_h1">Payment page</h1>
            <form onSubmit={formik.handleSubmit}>
              <div className="form-group">
                <label>Booking Data ID:</label>
                <input
                  type="text"
                  className="form-control"
                  name="bookingDataId"
                  value={formik.values.bookingDataId}
                  readOnly
                />
              </div>
              <div className="form-group">
                <label>Payment Method:</label>
                <select
                  className={`form-control ${
                    formik.errors.paymentMethod &&
                    formik.touched.paymentMethod &&
                    "is-invalid"
                  }`}
                  name="paymentMethod"
                  value={formik.values.paymentMethod}
                  onChange={formik.handleChange}
                  onBlur={formik.handleBlur}
                >
                  <option value="">Select a payment method</option>
                  <option value="CREDIT">Credit Card</option>
                  <option value="DEBIT">Debit Card</option>
                </select>
                {formik.errors.paymentMethod &&
                  formik.touched.paymentMethod && (
                    <div className="invalid-feedback">
                      {formik.errors.paymentMethod}
                    </div>
                  )}
              </div>
              <div className="form-group">
                <label>Card Number:</label>
                <input
                  type="number"
                  className={`form-control ${
                    formik.errors.cardNumber &&
                    formik.touched.cardNumber &&
                    "is-invalid"
                  }`}
                  name="cardNumber"
                  value={formik.values.cardNumber}
                  onChange={formik.handleChange}
                  onBlur={formik.handleBlur}
                />
                {formik.errors.cardNumber && formik.touched.cardNumber && (
                  <div className="invalid-feedback">
                    {formik.errors.cardNumber}
                  </div>
                )}
              </div>
              <div className="form-group">
                <label>Expiry Date:</label>
                <input
                  type="date"
                  className={`form-control ${
                    formik.errors.expiryDate &&
                    formik.touched.expiryDate &&
                    "is-invalid"
                  }`}
                  name="expiryDate"
                  value={formik.values.expiryDate}
                  onChange={formik.handleChange}
                  onBlur={formik.handleBlur}
                />
                {formik.errors.expiryDate && formik.touched.expiryDate && (
                  <div className="invalid-feedback">
                    {formik.errors.expiryDate}
                  </div>
                )}
              </div>
              <div className="form-group">
                <label>CVV:</label>
                <input
                  type="password"
                  className={`form-control ${
                    formik.errors.cvvNumber &&
                    formik.touched.cvvNumber &&
                    "is-invalid"
                  }`}
                  name="cvvNumber"
                  value={formik.values.cvvNumber}
                  onChange={formik.handleChange}
                  onBlur={formik.handleBlur}
                />
                {formik.errors.cvvNumber && formik.touched.cvvNumber && (
                  <div className="invalid-feedback">
                    {formik.errors.cvvNumber}
                  </div>
                )}
              </div>
              <div className="form-group">
                <label>Total Ticket Price:</label>
                <input
                  type="number"
                  className={`form-control ${
                    formik.errors.totalTicketPrice &&
                    formik.touched.totalTicketPrice &&
                    "is-invalid"
                  }`}
                  name="totalTicketPrice"
                  value={formik.values.totalTicketPrice}
                  readOnly
                />
              </div>
              <div
                style={{
                  alignItems: "center",
                  textAlign: "center",
                  paddingTop: "10px",
                }}
              >
                <button type="submit" className="btn btn-primary">
                  Make Payment
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </>
  );
};

export default PaymentPage;

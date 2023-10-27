import axios from "axios";
import React, { useEffect, useState } from "react";
import { NavLink, useNavigate, useParams } from "react-router-dom";

const getCurrentDate = () => {
  const today = new Date();
  const year = today.getFullYear();
  const month = String(today.getMonth() + 1).padStart(2, "0");
  const day = String(today.getDate()).padStart(2, "0");
  return `${day}-${month}-${year}`;
};

const EventBookingPage = () => {
  const loggedInUserId = 1;

  const [bookingResponse, setBookingResponse] = useState(null);
  const { eventId } = useParams();
  const [adults, setAdults] = useState(0);
  const [children, setChildren] = useState(0);
  const [foodChoices, setFoodChoices] = useState([]);
  const [eventData, setEventData] = useState([]);

  const [bookingDate] = useState(getCurrentDate());

  const handleAdultChange = (event) => {
    setAdults(parseInt(event.target.value));
  };

  const handleChildChange = (event) => {
    setChildren(parseInt(event.target.value));
  };

  const handleFoodChoiceChange = (personIndex, foodIndex, isChecked) => {
    const updatedFoodChoices = [...foodChoices];
    updatedFoodChoices[personIndex][foodIndex] = isChecked;
    setFoodChoices(updatedFoodChoices);
  };

  const calculateTotalPrice = () => {
    const childPrice = 10;
    const adultPrice = childPrice * 1.05;

    let totalPrice = 0;

    for (let i = 0; i < foodChoices.length; i++) {
      const personFoodChoices = foodChoices[i];
      if (i < adults) {
        totalPrice += adultPrice * personFoodChoices.filter(Boolean).length;
      } else {
        totalPrice += childPrice * personFoodChoices.filter(Boolean).length;
      }
    }

    return totalPrice.toFixed(2);
  };

  const renderFoodChoiceInputs = () => {
    const inputs = [];

    for (let i = 0; i < adults + children; i++) {
      const personType = i < adults ? "Adult" : "Child";
      const personNumber = i < adults ? i + 1 : i - adults + 1;

      const personFoodChoices = foodChoices[i] || [];

      for (let j = 0; j < 3; j++) {
        personFoodChoices[j] = personFoodChoices[j] || false;
      }

      inputs.push(
        <div key={i}>
          <p>
            {personType} {personNumber} Food Choices:
          </p>
          {personFoodChoices.map((isChecked, foodIndex) => (
            <div className="form-check form-check-inline" key={foodIndex}>
              <input
                className="form-check-input"
                type="checkbox"
                checked={isChecked}
                onChange={(event) =>
                  handleFoodChoiceChange(i, foodIndex, event.target.checked)
                }
              />
              <label className="form-check-label">
                {foodIndex === 0
                  ? "Breakfast"
                  : foodIndex === 1
                  ? "Lunch"
                  : "Dinner"}
              </label>
            </div>
          ))}
        </div>
      );
    }

    return inputs;
  };

  useEffect(() => {
    const newFoodChoices = [];

    for (let i = 0; i < adults + children; i++) {
      newFoodChoices.push(foodChoices[i] || []);
    }

    const fetchData = async () => {
      try {
        const response = await axios.get(
          `/api/admin/event/placeholder/eventedit/${eventId}/0`
        );
        setEventData(response.data);
      } catch (error) {
        console.error("Error fetching event data:", error);
      }
    };

    fetchData();

    setFoodChoices(newFoodChoices);
  }, [adults, children]);

  const navigate = useNavigate();
  const handleBack = () => {
    navigate(-1);
  };

  const formatDate = (date) => {
    const [day, month, year] = date.split("-");
    return `${year}-${month}-${day}`;
  };

  const formatDateForShow = (timestamp) => {
    const date = new Date(timestamp);
    const day = String(date.getDate()).padStart(2, "0");
    const month = String(date.getMonth() + 1).padStart(2, "0");
    const year = date.getFullYear();
    return `${day}-${month}-${year}`;
  };

  const handleBookTicket = () => {
    const numberOfBreakfast = foodChoices.reduce(
      (total, choices) => total + (choices[0] ? 1 : 0),
      0
    );
    const numberOfLunch = foodChoices.reduce(
      (total, choices) => total + (choices[1] ? 1 : 0),
      0
    );
    const numberOfDinner = foodChoices.reduce(
      (total, choices) => total + (choices[2] ? 1 : 0),
      0
    );
    const totalPrice = calculateTotalPrice();

    const bookingData = {
      eventId,
      bookingDate: formatDate(bookingDate),
      numberOfAdults: adults,
      numberOfChildren: children,
      numberOfBreakfast,
      numberOfLunch,
      numberOfDinner,
      totalPrice: parseFloat(totalPrice),
    };

    axios
      .post(`/api/booking/addbooking/${eventId}/${loggedInUserId}`, bookingData)
      .then((addBookingResponse) => {
        setBookingResponse(addBookingResponse.data);
        if (
          addBookingResponse.data === "You already registered for this event"
        ) {
          alert(addBookingResponse.data);
          navigate("/");
        } else {
          axios
            .get(`/api/booking/getbooking/${eventId}/${loggedInUserId}`)
            .then((getBookingResponse) => {
              // setBookingResponse(getBookingResponse.data);
              console.log(getBookingResponse.data);
              navigate(
                `/payment-page/${getBookingResponse.data.id}/${getBookingResponse.data.totalPrice}`
              );
            })
            .catch((error) => {
              console.error("Error fetching booking data:", error);
            });
        }
      })
      .catch((error) => {
        console.error("Error adding booking:", error);
      });
  };

  return (
    <>
      <NavLink to="#" className="btn" onClick={handleBack}>
        🔙
      </NavLink>
      <h1 className="container_eventbooking_h1">Event Booking</h1>
      <div className="container">
        <div className="row">
          <div className="col-md-6">
            <div className="card text-center">
              <div className="card-body">
                <h1 className="card-title">Booking Details</h1>
                <p>Event Name: {eventData.eventName}</p>
                <p>
                  Registration Open Date:{" "}
                  {formatDateForShow(eventData.registrationOpenDate)}
                </p>
                <p>
                  Registration Close Date:{" "}
                  {formatDateForShow(eventData.registrationCloseDate)}
                </p>
                <p>Event Start Time: {eventData.eventStartTime}</p>
                <p>Event Close Time: {eventData.eventCloseTime}</p>
                <p>Registration Fee: {eventData.registrationFee}</p>
                <p>Booking Date: {bookingDate}</p>
              </div>
            </div>
          </div>
          <div className="col-md-6">
            <div className="card">
              <h2 className="card-header">Choose Fooding</h2>
              <div className="card-body">
                <div className="mb-3">
                  <label className="form-label">
                    Number of Adults:
                    <input
                      className="form-control"
                      type="number"
                      value={adults}
                      onChange={handleAdultChange}
                    />
                  </label>
                </div>
                <div className="mb-3">
                  <label className="form-label">
                    Number of Children:
                    <input
                      className="form-control"
                      type="number"
                      value={children}
                      onChange={handleChildChange}
                    />
                  </label>
                </div>
                {renderFoodChoiceInputs()}
                <div>
                  <h3>Total Price</h3>
                  <p>${calculateTotalPrice()}</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <br />
      <div style={{ alignItems: "center", textAlign: "center" }}>
        <NavLink className="btn btn-primary" onClick={handleBookTicket} to="#">
          Submit
        </NavLink>
      </div>

      <br />
      <br />
    </>
  );
};

export default EventBookingPage;

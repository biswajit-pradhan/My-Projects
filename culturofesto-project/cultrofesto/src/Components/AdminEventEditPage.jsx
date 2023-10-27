import axios from "axios";
import React, { useState } from "react";
import { useEffect } from "react";
import { NavLink, useNavigate, useParams } from "react-router-dom";

const AdminEventEditPage = () => {
  const { eventId } = useParams();
  const [event, setEvent] = useState({});

  const formatDate = (timestamp) => {
    const date = new Date(timestamp);
    const day = String(date.getDate()).padStart(2, "0");
    const month = String(date.getMonth() + 1).padStart(2, "0");
    const year = date.getFullYear();
    return `${day}-${month}-${year}`;
  };

  const formatDateForUpdate = (timestamp) => {
    const date = new Date(timestamp);
    const day = String(date.getDate()).padStart(2, "0");
    const month = String(date.getMonth() + 1).padStart(2, "0");
    const year = date.getFullYear();
    return `${year}-${month}-${day}`;
  };

  const fetchEvent = async () => {
    try {
      const response = await axios.get(
        `/api/admin/event/placeholder/eventedit/${eventId}/0`
      );

      setEvent(response.data);
    } catch (error) {
      console.error("Error fetching event:", error);
    }
  };

  useEffect(() => {
    fetchEvent();
  }, []);

  const [eventName, setEventName] = useState(event.eventName);
  const [registrationOpenDate, setRegistrationOpenDate] = useState(
    event.registrationOpenDate
  );

  const [eventDate, setEventDate] = useState(event.eventDate);

  const [registrationCloseDate, setRegistrationCloseDate] = useState(
    event.registrationCloseDate
  );
  const [eventStartTime, setEventStartTime] = useState(event.eventStartTime);
  const [eventCloseTime, setEventCloseTime] = useState(event.eventCloseTime);
  const [registrationFee, setRegistrationFee] = useState(event.registrationFee);
  const [eventCapacity, setEventCapacity] = useState(event.eventCapacity);
  const [breakfastPrice, setBreakfastPrice] = useState(event.breakfastPrice);
  const [lunchPrice, setLunchPrice] = useState(event.lunchPrice);
  const [dinnerPrice, setDinnerPrice] = useState(event.dinnerPrice);
  const [eventImage, setEventImage] = useState(event.eventImage);

  const handleEventNameChange = (e) => {
    setEventName(e.target.value);
  };

  const handleEventDateChange = (e) => {
    setEventDate(e.target.value);
  };

  const handleRegistrationOpenDateChange = (e) => {
    setRegistrationOpenDate(e.target.value);
  };

  const handleRegistrationCloseDateChange = (e) => {
    setRegistrationCloseDate(e.target.value);
  };

  const handleEventStartTimeChange = (e) => {
    setEventStartTime(e.target.value);
  };

  const handleEventCloseTimeChange = (e) => {
    setEventCloseTime(e.target.value);
  };

  const handleRegistrationFeeChange = (e) => {
    const value = e.target.value;
    setRegistrationFee(
      value !== "" ? parseFloat(value) : event.registrationFee
    );
  };

  const handleEventCapacityChange = (e) => {
    const value = e.target.value;
    setEventCapacity(value !== "" ? parseInt(value) : event.eventCapacity);
  };

  const handleBreakfastPriceChange = (e) => {
    const value = e.target.value;
    setBreakfastPrice(value !== "" ? parseFloat(value) : event.breakfastPrice);
  };

  const handleLunchPriceChange = (e) => {
    const value = e.target.value;
    setLunchPrice(value !== "" ? parseFloat(value) : event.lunchPrice);
  };

  const handleDinnerPriceChange = (e) => {
    const value = e.target.value;
    setDinnerPrice(value !== "" ? parseFloat(value) : event.dinnerPrice);
  };

  const handleEventImageChange = (e) => {
    const file = e.target.files[0];
    const reader = new FileReader();
    reader.onload = () => {
      setEventImage(reader.result);
    };
    reader.readAsDataURL(file);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const formData = new FormData();
      const updatedEvent = {};

      // Handle event name
      updatedEvent.eventName =
        eventName !== undefined ? eventName : event.eventName;

      // Handle event date
      updatedEvent.eventDate =
        eventDate !== undefined
          ? eventDate
          : formatDateForUpdate(event.eventDate);

      // Handle registration open date
      updatedEvent.registrationOpenDate =
        registrationOpenDate !== undefined
          ? registrationOpenDate
          : formatDateForUpdate(event.registrationOpenDate);

      // Handle registration close date
      updatedEvent.registrationCloseDate =
        registrationCloseDate !== undefined
          ? registrationCloseDate
          : formatDateForUpdate(event.registrationCloseDate);

      // Handle event start time
      updatedEvent.eventStartTime =
        eventStartTime !== undefined ? eventStartTime : event.eventStartTime;

      // Handle event close time
      updatedEvent.eventCloseTime =
        eventCloseTime !== undefined ? eventCloseTime : event.eventCloseTime;

      // Handle registration fee
      updatedEvent.registrationFee =
        registrationFee !== undefined
          ? parseFloat(registrationFee)
          : event.registrationFee;

      // Handle event capacity
      updatedEvent.eventCapacity =
        eventCapacity !== undefined
          ? parseInt(eventCapacity)
          : event.eventCapacity;

      // Handle breakfast price
      updatedEvent.breakfastPrice =
        breakfastPrice !== undefined
          ? parseFloat(breakfastPrice)
          : event.breakfastPrice;

      // Handle lunch price
      updatedEvent.lunchPrice =
        lunchPrice !== undefined ? parseFloat(lunchPrice) : event.lunchPrice;

      // Handle dinner price
      updatedEvent.dinnerPrice =
        dinnerPrice !== undefined ? parseFloat(dinnerPrice) : event.dinnerPrice;

      updatedEvent.deleteStatus = "false";
      // Append event data to form data
      formData.append("event", JSON.stringify(updatedEvent));

      await axios.put(
        `http://localhost:9001/api/admin/event/eventedit/${eventId}`,
        formData,
        {
          headers: {
            "Content-Type": "multipart/form-data",
          },
        }
      );

      console.log("Updation Successfull");
    } catch (error) {
      console.error("Error updating event:", error);
      console.log("Some error occured");
    }
  };

  const navigate = useNavigate();
  const handleBack = () => {
    navigate(-1);
  };
  return (
    <>
      <NavLink to="#" onClick={handleBack} className="btn">
        🔙
      </NavLink>
      <div className="container admin_event_edit">
        <h1 className="mt-4 event_edit_title">Edit Event</h1>
        <form onSubmit={handleSubmit}>
          <div className="mb-3">
            <label className="form-label">Event Name:</label>
            <input
              placeholder={event.eventName}
              type="text"
              className="form-control"
              value={eventName}
              onChange={handleEventNameChange}
            />
          </div>
          <div className="mb-3">
            <label className="form-label">Event Date:</label>
            <input
              placeholder={event.eventDate ? formatDate(event.eventDate) : ""}
              type="text"
              onFocus={(e) => (e.target.type = "date")}
              className="form-control"
              value={eventDate}
              onChange={handleEventDateChange}
            />
          </div>

          <div className="row">
            <div className="col-md-6">
              <div className="mb-3">
                <label className="form-label">Registration Open Date:</label>
                <input
                  placeholder={
                    event.registrationOpenDate
                      ? formatDate(event.eventDate)
                      : ""
                  }
                  type="text"
                  onFocus={(e) => (e.target.type = "date")}
                  className="form-control"
                  value={registrationOpenDate}
                  onChange={handleRegistrationOpenDateChange}
                />
              </div>
            </div>
            <div className="col-md-6">
              <div className="mb-3">
                <label className="form-label">Registration Close Date:</label>
                <input
                  placeholder={
                    event.registrationCloseDate
                      ? formatDate(event.eventDate)
                      : ""
                  }
                  type="text"
                  onFocus={(e) => (e.target.type = "date")}
                  className="form-control"
                  value={registrationCloseDate}
                  onChange={handleRegistrationCloseDateChange}
                />
              </div>
            </div>
          </div>

          <div className="row">
            <div className="col-md-6">
              <div className="mb-3">
                <label className="form-label">Event Start Time:</label>
                <input
                  placeholder={event.eventStartTime}
                  type="text"
                  onFocus={(e) => (e.target.type = "time")}
                  className="form-control"
                  value={eventStartTime}
                  onChange={handleEventStartTimeChange}
                />
              </div>
            </div>
            <div className="col-md-6">
              <div className="mb-3">
                <label className="form-label">Event Close Time:</label>
                <input
                  placeholder={event.eventCloseTime}
                  type="text"
                  onFocus={(e) => (e.target.type = "time")}
                  className="form-control"
                  value={eventCloseTime}
                  onChange={handleEventCloseTimeChange}
                />
              </div>
            </div>
          </div>

          <div className="row">
            <div className="col-md-6">
              <div className="mb-3">
                <label className="form-label">Registration Fee:</label>
                <input
                  placeholder={event.registrationFee}
                  type="number"
                  className="form-control"
                  value={registrationFee}
                  onChange={handleRegistrationFeeChange}
                />
              </div>
            </div>
            <div className="col-md-6">
              <div className="mb-3">
                <label className="form-label">Event Capacity:</label>
                <input
                  placeholder={event.eventCapacity}
                  type="number"
                  className="form-control"
                  value={eventCapacity}
                  onChange={handleEventCapacityChange}
                />
              </div>
            </div>
          </div>

          <div className="row">
            <div className="col-md-4">
              <div className="mb-3">
                <label className="form-label">Breakfast Price:</label>
                <input
                  placeholder={event.breakfastPrice}
                  type="number"
                  className="form-control"
                  value={breakfastPrice}
                  onChange={handleBreakfastPriceChange}
                />
              </div>
            </div>
            <div className="col-md-4">
              <div className="mb-3">
                <label className="form-label">Lunch Price:</label>
                <input
                  placeholder={event.lunchPrice}
                  type="number"
                  className="form-control"
                  value={lunchPrice}
                  onChange={handleLunchPriceChange}
                />
              </div>
            </div>
            <div className="col-md-4">
              <div className="mb-3">
                <label className="form-label">Dinner Price:</label>
                <input
                  placeholder={event.dinnerPrice}
                  type="number"
                  className="form-control"
                  value={dinnerPrice}
                  onChange={handleDinnerPriceChange}
                />
              </div>
            </div>
          </div>

          <button
            type="submit"
            className="btn btn-primary"
            onClick={handleBack}
          >
            SAVE CHANGES
          </button>
          <span>
            <button className="btn btn-primary" onClick={handleBack}>
              CANCEL
            </button>
          </span>
        </form>
      </div>
    </>
  );
};

export default AdminEventEditPage;

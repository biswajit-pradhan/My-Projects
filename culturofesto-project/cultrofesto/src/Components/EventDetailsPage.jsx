import React, { useState, useEffect } from "react";
import { NavLink } from "react-bootstrap";
import { Link, useNavigate, useParams } from "react-router-dom";

const EventDetailsPage = () => {
  const { eventId } = useParams();
  const [event, setEvent] = useState(null);
  const [eventImage, setEventImage] = useState(null);

  const navigate = useNavigate();
  const handleBack = () => {
    navigate(-1);
  };

  useEffect(() => {
    const fetchEventDetails = async () => {
      try {
        const eventResponse = await fetch(`/api/event/${eventId}/0`);
        const eventData = await eventResponse.json();
        setEvent(eventData);

        const imageResponse = await fetch(`/api/event/${eventId}/1`);
        if (imageResponse.ok) {
          const imageBlob = await imageResponse.blob();
          setEventImage(URL.createObjectURL(imageBlob));
        }
      } catch (error) {
        console.error("Error fetching event details:", error);
      }
    };

    fetchEventDetails();
  }, [eventId]);

  if (!event) {
    return <div>Loading event details...</div>;
  }

  return (
    <>
      <div>
        <NavLink to="#" onClick={handleBack} className="btn back-link">
          <span className="back-link-icon">🔙</span>
        </NavLink>
        <h1 className="homepage_upcoming_title">Event Details</h1>
        <div
          style={{
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
            minHeight: "100%",
            paddingBottom: "200px",
          }}
        >
          <div className="navlink_event_details">
            <div className="event_details_data">
              {eventImage && (
                <img
                  src={eventImage}
                  alt="Event"
                  style={{
                    width: "500px",
                    height: "500px",
                    borderRadius: "5%",
                  }}
                />
              )}
              <h1 style={{ color: "ThreeDLightShadow" }}>{event.eventName}</h1>
              <p>Event Date: {event.eventDate}</p>
              <p>Registration Open Date: {event.registrationOpenDate}</p>
              <p>Registration Close Date: {event.registrationCloseDate}</p>
              <p>Event Start Time: {event.eventStartTime}</p>
              <p>Event Close Time: {event.eventCloseTime}</p>
              <p>Registration Fee : {event.registrationFee}</p>
              <p>Event Capacity: {event.eventCapacity}</p>
              <p>Breakfast Price: {event.breakfastPrice}</p>
              <p>Lunch Price: {event.lunchPrice}</p>
              <p>Dinner Price: {event.dinnerPrice}</p>
              <p>Hurry only {event.eventCapacity} tickets remaining...</p>
            </div>
            <Link to={`/event-booking/${event.id}`}>
              <button className="btn btn-primary">Book Ticket</button>
            </Link>
          </div>
        </div>
      </div>
    </>
  );
};

export default EventDetailsPage;

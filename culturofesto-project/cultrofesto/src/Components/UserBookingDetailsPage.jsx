import { useEffect, useState } from "react";
import { NavLink, useNavigate, useParams } from "react-router-dom";

const UserBookingDetailsPage = () => {
  const { eventId } = useParams();
  const [booking, setBooking] = useState(null);
  const navigate = useNavigate(); // Use the useNavigate hook

  const handleBack = () => {
    navigate(-1); // Use navigate instead of Navigate
  };

  useEffect(() => {
    const fetchEventDetails = async () => {
      try {
        const eventResponse = await fetch(
          `http://localhost:9005/api/user/regstd/event/booking-details/1234/12345`
        );
        const bookingData = await eventResponse.json();
        setBooking(bookingData);
        console.log(bookingData);
      } catch (error) {
        console.error("Error fetching event details:", error);
      }
    };
    fetchEventDetails();
  }, [eventId]);

  if (!booking) {
    return <div>Loading Booking details...</div>;
  }

  return (
    <>
      <div>
        <NavLink to="#" onClick={handleBack} className="btn back-link">
          <span className="back-link-icon">🔙</span>
        </NavLink>
        <h1 className="homepage_upcoming_title">Booking Details</h1>
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
              <h1 style={{ color: "ThreeDLightShadow" }}>
                Event Name: {booking.event.eventName}
              </h1>
              <p>Booking Date : {booking.bookingDate}</p>
              <p>Number of Booking: {booking.noOfBookings}</p>
              <p>Food Opted: {booking.foodOpted ? "No" : "Yes"}</p>
              {/* Rest of the component */}
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default UserBookingDetailsPage;

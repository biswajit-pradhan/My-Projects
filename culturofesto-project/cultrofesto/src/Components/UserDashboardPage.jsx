import { Button, Carousel, Modal } from "react-bootstrap";
import { NavLink, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";

const UserDashboardPage = () => {
  const userId = 1;
  const [feedBackEventId, setfeedBackEventId] = useState(0);
  const [EventDataUc, setEventDataUc] = useState([]);
  const [eventDataPst, setEventDataPst] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const [feedback, setFeedback] = useState("");
  const [feedbackData, setFeedbackData] = useState({});
  const navigate = useNavigate();
  const handleBack = () => {
    navigate(-1);
  };

  const [index, setIndex] = useState(0);

  const handleSelect = (selectedIndex) => {
    setIndex(selectedIndex);
  };

  const cancelBtnHandler = async (userId, eventId) => {
    try {
      const cancelResponse = await fetch(
        `/api/user/regstd/cancel/${userId}/${eventId}`,
        {
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
          },
        }
      );
      if (cancelResponse.ok) {
        // Cancellation successful and fetch updated event data
        fetchEventDetails();
      } else {
        console.error("Cancellation request failed:", cancelResponse.status);
      }
    } catch (error) {
      console.error("Error canceling booking:", error);
    }
  };

  const handleFeedbackModal = (eventId) => {
    setfeedBackEventId(eventId);
    setShowModal(true);
    // You can set any additional data related to the event or modal here
  };

  const handleSubmitFeedback = async (userid, eventid) => {
    try {
      const giveFeedBack = await fetch(
        `/api/feedback/post-feedback/${userid}/${eventid}`,
        {
          method: "POST",
          headers: {
            "Content-Type": "text/plain", // Update the Content-Type to text/plain
          },
          body: feedback, // Send the feedback as plain text
        }
      );

      if (giveFeedBack.ok) {
        // Cancellation successful and fetch updated event data
        fetchEventDetails();
        setShowModal(false);
      } else {
        console.error("Feedback posting failed:", giveFeedBack.status);
      }
    } catch (error) {
      console.error("Error in posting feedback:", error);
    }
  };

  const fetchEventDetails = async () => {
    try {
      const eventResponseUc = await fetch(
        `/api/user/uc-events/regstd/${userId}`
      );
      const ucEventData = await eventResponseUc.json();
      setEventDataUc(ucEventData);
    } catch (error) {
      console.error("Error fetching upcoming event details:", error);
    }

    try {
      const eventResponsePst = await fetch(
        `/api/user/pst-events/regstd/${userId}`
      );
      const pstEventData = await eventResponsePst.json();
      setEventDataPst(pstEventData);

      //Fetch feedback details for each event
      // pstEventData.forEach((event) => {
      //   fetchFeedbackDetails(event.id);
      // });
    } catch (error) {
      console.error("Error fetching past event details:", error);
    }
  };

  // useEffect(() => {
  //   fetchEventDetails();
  // });
  useEffect(() => {
    fetchEventDetails();
  }, []);

  useEffect(() => {
    // Fetch feedback details for each event
    eventDataPst.forEach((event) => {
      fetchFeedbackDetails(event.id);
    });
  }, [eventDataPst]);

  const fetchFeedbackDetails = async (eventid) => {
    try {
      const feedbackResponse = await fetch(
        `/api/feedback/get-feedback/${userId}/${eventid}`
      );
      if (!feedbackResponse.ok) {
        throw new Error("Failed to fetch feedback details");
      }
      const feedbackDt = await feedbackResponse.json();
      setFeedbackData((prevFeedbackData) => ({
        ...prevFeedbackData,
        [eventid]: feedbackDt, // Store feedback data using eventid as the key
      }));
    } catch (error) {
      console.error("Error fetching event and feedback details:", error);
    }
  };

  return (
    <div>
      <div>
        <NavLink to="#" onClick={handleBack} className="btn">
          🔙
        </NavLink>
        <h3 className="user_upcoming">Upcoming Registered Events</h3>
        <div className="scrollable-container">
          {EventDataUc.map((event) => (
            <div
              className="card"
              key={event.id}
              style={{
                width: "800px",
                alignItems: "center",
                textAlign: "center",
              }}
            >
              <div className="card-body d-flex flex-column">
                <h5 className="card-title">{event.eventName}</h5>
                <h6 className="card-subtitle mb-2 text-muted">
                  Event Id: {event.id}
                </h6>
                <div className="card-text overflow-auto">
                  <p>Event Date: {event.eventDate}</p>
                </div>
                <div className="button-container">
                  <NavLink to={`/booking-details`} className="btn btn-primary">
                    Booking Details
                  </NavLink>
                  <button
                    onClick={() => cancelBtnHandler(userId, event.id)}
                    className="btn btn-primary"
                  >
                    Cancel Booking
                  </button>
                </div>
              </div>
            </div>
          ))}
        </div>
      </div>

      <div>
        <h3 className="user_upcoming">Last 5 Month Events you attended</h3>
        <div>
          <Carousel
            style={{ display: "flex", justifyContent: "center" }}
            activeIndex={index}
            onSelect={handleSelect}
            // interval={1500}
            indicators={false}
          >
            {eventDataPst.map((event) => (
              <Carousel.Item key={event.id}>
                <div className="d-flex justify-content-center">
                  <div className="card" style={{ width: "50rem" }}>
                    <div className="card-body d-flex flex-column align-items-center">
                      <h5 className="card-title">{event.eventName}</h5>
                      <h6 className="card-subtitle mb-2 text-muted">
                        Event Id: {event.id}
                      </h6>
                      {feedbackData[event.id] &&
                      feedbackData[event.id].feedbackText ? (
                        <p>
                          Your Feedback: {feedbackData[event.id].feedbackText}
                        </p>
                      ) : (
                        <NavLink
                          to="#"
                          onClick={() => handleFeedbackModal(event.id)}
                          className="btn btn-primary"
                        >
                          Give Feedback
                        </NavLink>
                      )}
                    </div>
                  </div>
                </div>
              </Carousel.Item>
            ))}
          </Carousel>

          {/*///////////////////////////////////////Feedback Modal////////////////////// */}
          <Modal show={showModal} onHide={() => setShowModal(false)}>
            <Modal.Header closeButton>
              <Modal.Title>Give Feedback</Modal.Title>
            </Modal.Header>
            <Modal.Body>
              <p>Event Id: {feedBackEventId}</p>
              <textarea
                value={feedback}
                onChange={(e) => setFeedback(e.target.value)}
                placeholder="Write your feedback..."
                rows={5}
                cols={50}
              />
            </Modal.Body>
            <Modal.Footer>
              <Button variant="secondary" onClick={() => setShowModal(false)}>
                Cancel
              </Button>
              <Button
                variant="primary"
                onClick={() => handleSubmitFeedback(userId, feedBackEventId)}
              >
                Submit Feedback
              </Button>
            </Modal.Footer>
          </Modal>
        </div>
      </div>
    </div>
  );
};

export default UserDashboardPage;

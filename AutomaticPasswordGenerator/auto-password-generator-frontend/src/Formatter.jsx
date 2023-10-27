import Validate from "./Validate";
import Send from "./Send";

const Formatter = () => {
  return (
    <>
      <div className="row">
        <div className="col-md-6">
          <Send />
        </div>
        <div className="col-md-6">
          <Validate />
        </div>
      </div>
    </>
  );
};
export default Formatter;

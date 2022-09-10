import CounterCC from "./components/CounterCC";
import CounterFC from "./components/CounterFC";

const App = () => (
  <section className="container-fluid p-4">
    <h5>Class Component Life Cycle Methods Demo</h5>
    <CounterCC />

    <h5>Function Component React Hooks Demo</h5>
    <CounterFC />

  </section>
);

export default App;

import Hero from "../components/Hero";
import Main from "../components/Main";

const Home = () => {
  return (
    <h1 className="flex flex-col gap-8">
      <Hero />
      <Main />
    </h1>
  );
};

export default Home;

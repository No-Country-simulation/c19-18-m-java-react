import { FontAwesomeIcon } from "@fortawesome/react-fontawesome"; // Import for icons

const Footer = () => {
  return (
    <footer className="bg-blue-700 text-white text-center py-4 flex justify-between">
      <p className="px-4 mb-4 w-[16rem]">
        Lorem ipsum dolor, sit amet consectetur adipisicing elit. Repellat ullam
        cupiditate voluptates mollitia eaque aut assumenda accusamus. Suscipit,
        voluptatibus iste?
      </p>
      <div className="flex justify-center space-x-4 px-4">
        social media icons
        <FontAwesomeIcon
          icon="fa-facebook"
          className="text-2xl hover:text-blue-600"
        />
        <FontAwesomeIcon
          icon="fa-twitter"
          className="text-2xl hover:text-blue-600"
        />
        <FontAwesomeIcon
          icon="fa-instagram"
          className="text-2xl hover:text-blue-600"
        />
      </div>
    </footer>
  );
};

export default Footer;
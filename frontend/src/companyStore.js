import { create } from 'zustand';
import axios from 'axios'; // Import axios

const companyStore = create((set) => ({
  companies: [],
  fetchCompanies: async () => {
    try {
      const response = await axios.get('http://localhost:8080/companies');
      set((state) => ({ companies: response.data }));
    } catch (error) {
      console.error('Error fetching companies:', error);
    }
  },
}));

export default companyStore;
import axios from 'axios'   

const apiBaseUrl = import.meta.env.VITE_REST_API_BASE_URL

export const fetchCandidateDashboardAPI = async (email) => {
    return await axios.get(`${apiBaseUrl}/api/candidate/dashboard`, { withCredentials: true });
}

export const fetchCompanyDashboardAPI = async (email) => {
    return await axios.get(`${apiBaseUrl}/api/company/dashboard`, { withCredentials: true });
}


import axios from 'axios'

const apiBaseUrl = import.meta.env.VITE_REST_API_BASE_URL

export const registerCandidate = async (candidateData) => {
    return await axios.post(`${apiBaseUrl}/api/auth/candidate/register`, candidateData)
}

export const login = async (username, password) => {

    console.log("Attempting login for:", username);
    console.log("Password provided:", password);

    const formData = new FormData();
    formData.append("email", username);
    formData.append("password", password);

    return await axios.post(`${apiBaseUrl}/api/auth/login`, formData, { withCredentials: true });

}


export const registerCompany = async (companyData) => {
    return await axios.post(`${apiBaseUrl}/api/auth/company/register`, companyData)
}


import { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import { fetchCompanyDashboardAPI } from '../../services/DashboardService'

const CompanyDashboard = () => {
  const [apiData, setApiData] = useState('')
    const navigate = useNavigate()

    useEffect(() => {

        fetchCompanyDashboardAPI().then((response) => {

            console.log('Dashboard data:', response.data)
            setApiData(response.data)

            navigate(`/company/dashboard/${response.data.id}`)

        }).catch((error) => {
            console.error('Error fetching dashboard data:', error)
        })

    }, [])


    return (
        <div>
            <h1 className='text-center'>Hello {apiData.name} </h1>
            <ul className='text-center'>
                <li>Email: {apiData.email}</li>
                <li>Phone: {apiData.phone}</li>
                <li>Role: {apiData.role}</li>
                <li>Industry: {apiData.industry}</li>
                <li>User ID: {apiData.id}</li>
            </ul>
        </div>
    )
}

export default CompanyDashboard
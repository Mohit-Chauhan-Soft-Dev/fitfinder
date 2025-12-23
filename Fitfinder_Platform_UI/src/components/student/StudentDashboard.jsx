import { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import { fetchCandidateDashboardAPI } from '../../services/DashboardService'


const StudentDashboard = () => {

    const [apiData, setApiData] = useState('')
    const navigate = useNavigate()

    useEffect(() => {

        fetchCandidateDashboardAPI().then((response) => {

            console.log('Dashboard data:', response.data)
            setApiData(response.data)

            navigate(`/student/dashboard/${response.data.id}`)

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
                <li>User ID: {apiData.id}</li>
            </ul>
        </div>
    )
}

export default StudentDashboard
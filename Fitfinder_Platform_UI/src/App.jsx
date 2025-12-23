import './index.css';
import { Navbar } from './components/Navbar';
import { Footer } from './components/Footer';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom'
import HomePage from './components/HomePage';
import AboutUs from './components/AboutUs';
import ContactUs from './components/ContactUs';
import LoginPage from './components/LoginPage';
import RegisterPage from './components/RegisterPage';
import AdminLogin from './components/AdminLogin';
import { useState } from 'react';
import StudentDashboard from './components/student/StudentDashboard';
import CompanyDashboard from './components/company/CompanyDashboard';

export default function App() {
  

  // const renderPage = () => {
  //   switch (currentPage) {
  //     case 'home':
  //       return <HomePage onNavigate={setCurrentPage} />;
  //     case 'about':
  //       return <AboutUs />;
  //     case 'contact':
  //       return <ContactUs />;
  //     case 'login':
  //       return <LoginPage onNavigate={setCurrentPage} />;
  //     case 'register':
  //       return <RegisterPage onNavigate={setCurrentPage} />;
  //     case 'admin':
  //       return <AdminLogin onNavigate={setCurrentPage} />;
  //     default:
  //       return <HomePage onNavigate={setCurrentPage} />;
  //   }
  // };

  return (
    <div className="min-h-screen flex flex-col">
      {/* <Navbar currentPage={currentPage} onNavigate={setCurrentPage} />

      <main className="grow">
        {renderPage()}
      </main>

      <Footer onNavigate={setCurrentPage} /> */}

      <Router>
        <Navbar />
        <Routes>
          {/* Define your routes here */}
          <Route path="/" element={<HomePage />} />
          <Route path="/about" element={<AboutUs />} />
          <Route path="/contact" element={<ContactUs />} />
          <Route path="/login" element={<LoginPage />} />
          <Route path="/register" element={<RegisterPage />} />
          <Route path="/admin" element={<AdminLogin />} />
          <Route path="/student/dashboard" element={<StudentDashboard />} />
          <Route path="/student/dashboard/:id" element={<StudentDashboard />} />
          <Route path="/company/dashboard" element={<CompanyDashboard />} />
          <Route path="/company/dashboard/:id" element={<CompanyDashboard />} />
        </Routes>
        <Footer />
      </Router>

    </div>
  );
}

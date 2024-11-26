<template>
    <div class="contact-container">
      <h1 class="title">Contact Us</h1>
      <p class="subtitle">We'd love to hear from you! Feel free to reach out through the form below.</p>
  
      <form class="contact-form">
        <div class="form-group">
          <label for="name">Name</label>
          <input type="text" id="name" placeholder="Enter your name" />
        </div>
        <div class="form-group">
          <label for="email">Email</label>
          <input type="email" id="email" placeholder="Enter your email" />
        </div>
        <div class="form-group">
          <label for="message">Message</label>
          <textarea id="message" placeholder="Write your message"></textarea>
        </div>
        <button type="submit" class="submit-button">Send</button>
      </form>
    </div>
  </template>
  
  <script>
  export default {
    name: "ContactPage",
  };
  </script>
  
  <style scoped>
  .contact-container {
    max-width: 600px;
    margin: 0 auto;
    padding: 20px;
    background-color: #e0f7fa;
    border-radius: 8px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    font-family: Arial, sans-serif;
    color: #007b83;
  }
  
  .title {
    text-align: center;
    font-size: 2rem;
    margin-bottom: 10px;
  }
  
  .subtitle {
    text-align: center;
    font-size: 1.2rem;
    margin-bottom: 20px;
    color: #005960;
  }
  
  .contact-form {
    display: flex;
    flex-direction: column;
    gap: 15px;
  }
  
  .form-group {
    display: flex;
    flex-direction: column;
  }
  
  label {
    font-weight: bold;
    margin-bottom: 5px;
  }
  
  input,
  textarea {
    padding: 10px;
    border: 1px solid #b2ebf2;
    border-radius: 4px;
    font-size: 1rem;
  }
  
  input:focus,
  textarea:focus {
    border-color: #007b83;
    outline: none;
    box-shadow: 0 0 5px rgba(0, 123, 131, 0.3);
  }
  
  textarea {
    resize: vertical;
    min-height: 100px;
  }
  
  .submit-button {
    padding: 10px 20px;
    background-color: #007b83;
    color: white;
    border: none;
    border-radius: 4px;
    font-size: 1rem;
    cursor: pointer;
    transition: background-color 0.3s;
  }
  
  .submit-button:hover {
    background-color: #005960;
  }
  </style>
  
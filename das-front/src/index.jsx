import React from "react";
import ReactDOM from "react-dom";
import Hello from "./components/Hello.jsx"
import TestButton from "./components/TestButton.jsx";
import CurrentDateTime from "./components/CurrentDateTime.jsx";
import LoginForm from "./components/loginForm.jsx";

ReactDOM.render(
    <div>
        <LoginForm/>
        <Hello name="Sergei"/>
        <Hello/>
        <TestButton/>
        <CurrentDateTime/>
    </div>,
    document.getElementById("app")
);
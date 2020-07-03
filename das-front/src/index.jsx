import React from "react";
import ReactDOM from "react-dom";
import Hello from "./components/Hello.jsx"
import TestButton from "./components/TestButton.jsx";
import CurrentDateTime from "./components/CurrentDateTime.jsx";

ReactDOM.render(
    <div>
        <Hello name="Sergei"/>
        <Hello/>
        <TestButton/>
        <CurrentDateTime/>
    </div>,
    document.getElementById("app")
);
import React from "react";
import ReactDOM from "react-dom";
import Hello from "./components/Hello.jsx"
import TestButton from "./components/TestButton.jsx";

ReactDOM.render(
    <div>
        <Hello name="Sergei"/>
        <Hello/>
        <TestButton/>
    </div>,
    document.getElementById("app")
);
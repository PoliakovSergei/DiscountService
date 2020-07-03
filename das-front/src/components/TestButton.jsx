import React, { Component } from 'react';

import '../styles/Buttons.scss'

class TestButton extends Component {
    constructor(props) {
        super(props);
        this.state = {color: "custom_button__off", text: "OFF"};
    }

    press = () => {
        const { color, text } = this.state;
        this.setState({
            color: color === "custom_button__off" ? "custom_button__on" : "custom_button__off",
            text: text === "OFF" ? "ON" : "OFF"
        });
    };

    render() {
        return <button onClick={this.press} className={"custom_button " + this.state.color}>{this.state.text}</button>;
    }
}

export default TestButton;
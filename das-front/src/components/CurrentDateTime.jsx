import React, { Component } from 'react';

class CurrentDateTime extends Component {
    constructor(props) {
        super(props);
        this.state = {date: new Date()};
    }

    componentDidMount() {
        this.timerId = setInterval(()=> this.tick(), 1000);
    }

    componentWillUnmount() {
        clearInterval(this.timerId);
    }

    tick() {
        this.setState({
            date: new Date()
        });
    }

    render() {
        return <p>Now: {this.state.date.toString()}</p>
    }
}

export default CurrentDateTime;
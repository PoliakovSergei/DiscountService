import React, {Component} from 'react';

import '../styles/Hello.css'

class Hello extends Component {
    constructor(props) {
        super(props);
        let { name } = this.props;
        if (name === Hello.defaultProps.name) {
            this.state = {info: "Default info in Hello.state"};
        }
        else {
            this.state = {info: "Glad to see you, " + name + "!"};
        }
    }

    render() {
        return <div>
            <h1>Hello, {this.props.name}!</h1>
            <p>{this.state.info}</p>
        </div>;
    }
}

Hello.defaultProps = {name: "Guest"}
export default Hello;
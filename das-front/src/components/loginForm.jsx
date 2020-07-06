import React, { Component } from 'react';

import '../styles/Forms.scss';

class LoginForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            name: "",
            password: ""
        }
    }

    onNameChange = (e) => {
        let name = e.target.value;
        this.setState({name: name});
    };

    onPasswordChange = (e) => {
        let password = e.target.value;
        this.setState({password: password});
    };

    handleSubmit = (e) => {
        e.preventDefault();
        alert(this.state.name + " : " + this.state.password);
    }

    render() {
        return (
            <div className="basic_form">
                <form onSubmit={this.handleSubmit}>
                    <p>
                        <label>Login:</label>
                        <input type="text" value={this.state.name} onChange={this.onNameChange}/>
                    </p>
                    <p>
                        <label>Password:</label>
                        <input type="password" value={this.state.password} onChange={this.onPasswordChange}/>
                    </p>
                    <input type="submit" value="Sign in"/>
                </form>
            </div>
        );
    }
}

export default LoginForm;
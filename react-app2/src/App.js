import React, { Component } from 'react';
import './App.css';
import axios from 'axios';

class App extends Component {

  constructor() {
    super();
    this.handleSubmit = this.handleSubmit.bind(this);
    this.state = {
      custName:'',
      cardno:'',
      creditLimit:'',
      data:[]
    };

  }

  getInitialState() {
    return {
      show: false,
      error: false
    };
  }

  handleChange = (e) => {
   this.setState({ [e.target.name]: e.target.value });
  }

   componentDidMount() {
     axios.get(`http://localhost:7080/api/users`).then(result => 
      this.setState({data: result.data}))
    .then(
      this.setState({
        show: true,
        error: false

      })).catch(error => {
        this.setState({
          show: false,
          error: true
        })
      })
  }

  async handleSubmit(event) {
    event.preventDefault();
    const {custName, cardno, creditLimit} = this.state;    
    axios.post(`http://localhost:7080/api/register`, {custName, cardno, creditLimit})
    .then((axios.get(`http://localhost:7080/api/users`).then(result => 
      this.setState({data: result.data})))
    .then(
      this.setState({
        show: true,
        error: false

      }))).catch(error => {
        this.setState({
          show: false,
          error: true
        })
        console.log(error);
      });
  }

  render() {
    const {custName, cardno, creditLimit, show, data, error} = this.state;
    const divStyle = {
      color: 'red',
      text: 'bold'
    };
      return (
        <p>
      <div class="container">
        <form onSubmit={this.handleSubmit}>
        <h1>Credit Card System </h1>
        <h2> Add </h2>
        <p/>  
        <span>
          Name
          <br/>
        <input id="custName" name="custName" type="text" value={custName} onChange={this.handleChange}/>
        </span>
        <br/>
        <p></p>
          Card Number
          <br/>
        <input id="cardno" name="cardno" type="number" maxlength="50" value={cardno} onChange={this.handleChange}/>
        <br/>
        <p></p>

          Limit
          <br/>
        <input id="creditLimit" name="creditLimit" type="number" value={creditLimit} onChange={this.handleChange}/>
        <br/>
        <p></p>

        <p/>  
        <button>Add</button>
      </form>
      
      </div>
        {error ?
        <div class="container">
        <h2 style={divStyle}>Invalid Credit Card details</h2>
        </div>
        : null}
       { show ?
              <div class="container">
            <h1>Existing Cards</h1>
     

            <table>
            <tr>
              <th>Name</th>
              <th>Card Number</th>
              <th>Balance</th>
              <th>Limit</th>
            </tr>
              
            { data.map((item)=>
    
            <tr>
  
              <td className="right">{item.custName}</td>
              <td className="right">{item.cardno}</td>
              <td className="right">{item.balance}</td>
              <td className="right">{item.creditLimit}</td>

            </tr>
            )}
          </table>
        </div>
      : null}
      </p>
    ); 
  }
}

export default App;

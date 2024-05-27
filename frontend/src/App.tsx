import React from 'react';
import logo from './logo.svg';
import './App.css';
import {Button, Slider, Typography} from "@mui/material";
const marks = [
    {
        value: -15,
        label: '-15°C',
    },
    {
        value: 45,
        label: '45°C',
    },
    {
        value: 0,
        label: '0°C',
    },
];
const minDistance = 10;

function valuetext(value: number) {
    return `${value}°C`;
}


function App() {
  return (
    <div className="App">
      <header className="App-header">
          <form>
              <label>
                  Cena smeštaja (po noći):
                  <br/>
                  <br/>
                  <Typography gutterBottom>Min</Typography>
                  <Slider disableSwap defaultValue={50} aria-label="Default" min={0} max={200} step={10} valueLabelDisplay="auto"/>
                  <Typography gutterBottom>Max</Typography>
                  <Slider defaultValue={50} aria-label="Default" min={0} max={200} step={10} valueLabelDisplay="auto"/>
              </label>

              <label>
                  Prosečna temperatura:
                  <br/>
                  <br/>
                  <Typography gutterBottom>Min</Typography>
                  <Slider
                      aria-label="auto"
                      defaultValue={80}
                      getAriaValueText={valuetext}
                      min={-15}
                      max={45}
                      marks={marks}
                      valueLabelDisplay="auto"
                  />
                  <Typography gutterBottom>Max</Typography>
                  <Slider
                      aria-label="auto"
                      defaultValue={80}
                      getAriaValueText={valuetext}
                      min={-15}
                      max={45}
                      marks={marks}
                      valueLabelDisplay="auto"
                  />
              </label>
              <br/>
              <br/>
              <Button variant="contained">Text</Button>
              <br/>
          </form>
      </header>

    </div>
  );
}

export default App;

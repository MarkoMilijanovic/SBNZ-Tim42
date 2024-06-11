import React from 'react';
import './App.css';
import {
    Button,
    Dialog,
    DialogTitle,
    FormControlLabel,
    Grid,
    List,
    ListItemButton, ListItemText,
    Radio,
    RadioGroup,
    Slider
} from "@mui/material";
import axios from 'axios';

// float min_cena;
// float max_cena;
// float min_temperatura;
// float max_temperatura;
// int min_nocni_zivot;
// int max_nocni_zivot;
// int min_urbanost;
// int max_urbanost;
// int[] najposeceniji_period_godine;
// Boolean dostupnost_gradskog_prevoza;
// int min_luksuz;
// int max_luksuz;
// Boolean vodene_povrsine;
// int min_hrana;
// int max_hrana;
// Boolean skijalista;

const marksTemp = [
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
const marksCost = [
    {
        value: 0,
        label: '0',
    },
    {
        value: 200,
        label: '200',
    },
];
const marks = [
    {
        value: 0,
        label: '0',
    },
    {
        value: 10,
        label: '10',
    },
];
const marksMeseci = [
    {
        value: 1,
        label: '1',
    },
    {
        value: 12,
        label: '12',
    },
];
export interface SimpleDialogProps {
    open: boolean;
    onClose: () => void;
}

const minDistancePrice = 20;
const minDistanceTemp = 5;
const minDistance = 1;

function valuetext(value: number) {
    return `${value}`;
}

export interface SimpleDialogProps {
    open: boolean;
    onClose: () => void;
}

function SimpleDialog(props: SimpleDialogProps) {
    const { onClose, open } = props;

    const handleClose = () => {
        onClose();
    };

    return (
        <Dialog onClose={handleClose} open={open}>
            <DialogTitle>Predloženo mesto za izlet:</DialogTitle>
        </Dialog>
    );
}

function App() {
    // Slider Variables
    const [valueCost, setCost] = React.useState<number[]>([50, 90]);
    const [valueTemp, setTemp] = React.useState<number[]>([0, 20]);
    const [valueNZ, setNZ] = React.useState<number[]>([2, 3]);
    const [valueUrbanost, setUrbanost] = React.useState<number[]>([2, 3]);
    const [valueHrana, setHrana] = React.useState<number[]>([2, 3]);
    const [valueLuksuz, setLuksuz] = React.useState<number[]>([2, 3]);
    const [valueMeseci, setMeseci] = React.useState<number[]>([2, 3]);

    // Radio Variables
    const [valueGP, setGP] = React.useState<number>(0)
    const [valueVP, setVP] = React.useState<number>(0)
    const [valueSkijalista, setSkijalista] = React.useState<number>(0)

    // Slider handlers
    const handleChangeCost = (event: Event, newValue: number | number[], activeThumb: number) => {
        if (!Array.isArray(newValue)) {
            return;
        }
        if (activeThumb === 0) {
            setCost([Math.min(newValue[0], valueCost[1] - minDistancePrice), valueCost[1]]);
        } else {
            setCost([valueCost[0], Math.max(newValue[1], valueCost[0] + minDistancePrice)]);
        }
    };
    const handleChangeTemp = (event: Event, newValue: number | number[], activeThumb: number) => {
        if (!Array.isArray(newValue)) {
            return;
        }
        if (activeThumb === 0) {
            setTemp([Math.min(newValue[0], valueTemp[1] - minDistanceTemp), valueTemp[1]]);
        } else {
            setTemp([valueTemp[0], Math.max(newValue[1], valueTemp[0] + minDistanceTemp)]);
        }
    };
    const handleChangeNZ = (event: Event, newValue: number | number[], activeThumb: number) => {
        if (!Array.isArray(newValue)) {
            return;
        }
        if (activeThumb === 0) {
            setNZ([Math.min(newValue[0], valueNZ[1] - minDistance), valueNZ[1]]);
        } else {
            setNZ([valueNZ[0], Math.max(newValue[1], valueNZ[0] + minDistance)]);
        }
    };
    const handleChangeUrbanost = (event: Event, newValue: number | number[], activeThumb: number) => {
        if (!Array.isArray(newValue)) {
            return;
        }
        if (activeThumb === 0) {
            setUrbanost([Math.min(newValue[0], valueUrbanost[1] - minDistance), valueUrbanost[1]]);
        } else {
            setUrbanost([valueUrbanost[0], Math.max(newValue[1], valueUrbanost[0] + minDistance)]);
        }
    };
    const handleChangeHrana = (event: Event, newValue: number | number[], activeThumb: number) => {
        if (!Array.isArray(newValue)) {
            return;
        }
        if (activeThumb === 0) {
            setHrana([Math.min(newValue[0], valueHrana[1] - minDistance), valueHrana[1]]);
        } else {
            setHrana([valueHrana[0], Math.max(newValue[1], valueHrana[0] + minDistance)]);
        }
    };
    const handleChangeLuksuz = (event: Event, newValue: number | number[], activeThumb: number) => {
        if (!Array.isArray(newValue)) {
            return;
        }
        if (activeThumb === 0) {
            setLuksuz([Math.min(newValue[0], valueLuksuz[1] - minDistance), valueLuksuz[1]]);
        } else {
            setLuksuz([valueLuksuz[0], Math.max(newValue[1], valueLuksuz[0] + minDistance)]);
        }
    };
    const handleChangeMeseci = (event: Event, newValue: number | number[], activeThumb: number) => {
        if (!Array.isArray(newValue)) {
            return;
        }
        if (activeThumb === 0) {
            setMeseci([Math.min(newValue[0], valueMeseci[1] - minDistance), valueMeseci[1]]);
        } else {
            setMeseci([valueMeseci[0], Math.max(newValue[1], valueMeseci[0] + minDistance)]);
        }
    };

    // Radio handlers
    const handleChangeGP = (event: React.ChangeEvent<HTMLInputElement>) => {
        setGP(parseInt((event.target as HTMLInputElement).value));
    };
    const handleChangeVP = (event: React.ChangeEvent<HTMLInputElement>) => {
        setVP(parseInt((event.target as HTMLInputElement).value));
    };
    const handleChangeSkijalista = (event: React.ChangeEvent<HTMLInputElement>) => {
        setSkijalista(parseInt((event.target as HTMLInputElement).value));
    };

    //openRec
    const [open, setOpen] = React.useState(false);

    const openRec =() =>{
        setOpen(true);
    }
    const handleClose = () => {
        axios.get('http://localhost:8080/recommend')
            .then(function (response) {
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });
        setOpen(false);
    };

    return (
        <div className="App">
            <header className="App-header">
                <form>
                    <Grid container spacing={10} rowSpacing={3}>
                        {/*ROW 1*/}
                        <Grid item xs={2}></Grid>
                        <Grid item xs={4}>
                            <label>
                                Cena smeštaja (po noći):
                                <br/>
                                <br/>
                                <Slider
                                    sx={{
                                        '& .MuiSlider-markLabel': {
                                            color: 'white',
                                        },
                                    }}
                                    getAriaLabel={() => 'Cena'}
                                    value={valueCost}
                                    onChange={handleChangeCost}
                                    valueLabelDisplay="auto"
                                    getAriaValueText={valuetext}
                                    min={0}
                                    max={200}
                                    marks={marksCost}
                                    disableSwap
                                />
                            </label>
                        </Grid>
                        <Grid item xs={4}>
                            <label>
                                Prosečna temperatura:
                                <br/>
                                <br/>
                                <Slider
                                    sx={{
                                        '& .MuiSlider-markLabel': {
                                            color: 'white',
                                        },
                                    }}
                                    getAriaLabel={() => 'Cena'}
                                    value={valueTemp}
                                    defaultValue={80}
                                    onChange={handleChangeTemp}
                                    valueLabelDisplay="auto"
                                    getAriaValueText={valuetext}
                                    min={-15}
                                    max={45}
                                    marks={marksTemp}
                                    disableSwap
                                />
                            </label>
                        </Grid>
                        <Grid item xs={2}></Grid>

                        {/*ROW 2*/}
                        <Grid item xs={2}></Grid>
                        <Grid item xs={4}>
                            <label>
                                Noćni život:
                                <br/>
                                <br/>
                                <Slider
                                    sx={{
                                        '& .MuiSlider-markLabel': {
                                            color: 'white',
                                        },
                                    }}
                                    getAriaLabel={() => 'Cena'}
                                    value={valueNZ}
                                    defaultValue={80}
                                    onChange={handleChangeNZ}
                                    valueLabelDisplay="auto"
                                    getAriaValueText={valuetext}
                                    min={0}
                                    max={10}
                                    marks={marks}
                                    disableSwap
                                />
                            </label>
                        </Grid>
                        <Grid item xs={4}>
                            <label>
                                Urbanost:
                                <br/>
                                <br/>
                                <Slider
                                    sx={{
                                        '& .MuiSlider-markLabel': {
                                            color: 'white',
                                        },
                                    }}
                                    getAriaLabel={() => 'Cena'}
                                    value={valueUrbanost}
                                    defaultValue={80}
                                    onChange={handleChangeUrbanost}
                                    valueLabelDisplay="auto"
                                    getAriaValueText={valuetext}
                                    min={0}
                                    max={10}
                                    marks={marks}
                                    disableSwap
                                />
                            </label>
                        </Grid>
                        <Grid item xs={2}></Grid>

                        {/*ROW 3*/}
                        <Grid item xs={2}></Grid>
                        <Grid item xs={4}>
                            <label>
                                Luksuz:
                                <br/>
                                <br/>
                                <Slider
                                    sx={{
                                        '& .MuiSlider-markLabel': {
                                            color: 'white',
                                        },
                                    }}
                                    getAriaLabel={() => 'Cena'}
                                    value={valueLuksuz}
                                    defaultValue={80}
                                    onChange={handleChangeLuksuz}
                                    valueLabelDisplay="auto"
                                    getAriaValueText={valuetext}
                                    min={0}
                                    max={10}
                                    marks={marks}
                                    disableSwap
                                />
                            </label>
                        </Grid>
                        <Grid item xs={4}>
                            <label>
                                Hrana:
                                <br/>
                                <br/>
                                <Slider
                                    sx={{
                                        '& .MuiSlider-markLabel': {
                                            color: 'white',
                                        },
                                    }}
                                    getAriaLabel={() => 'Cena'}
                                    value={valueHrana}
                                    defaultValue={80}
                                    onChange={handleChangeHrana}
                                    valueLabelDisplay="auto"
                                    getAriaValueText={valuetext}
                                    min={0}
                                    max={10}
                                    marks={marks}
                                    disableSwap
                                />
                            </label>
                        </Grid>
                        <Grid item xs={2}></Grid>

                        {/*ROW 4*/}
                        <Grid item xs={4}></Grid>
                        <Grid item xs={4}>

                            <label>
                                Najposećeniji period godine:
                                <Slider
                                    sx={{
                                        '& .MuiSlider-markLabel': {
                                            color: 'white',
                                        },
                                    }}
                                    getAriaLabel={() => 'Cena'}
                                    value={valueMeseci}
                                    defaultValue={80}
                                    onChange={handleChangeMeseci}
                                    valueLabelDisplay="auto"
                                    getAriaValueText={valuetext}
                                    min={1}
                                    max={12}
                                    marks={marksMeseci}
                                    disableSwap
                                />
                            </label>
                        </Grid>
                        <Grid item xs={4}></Grid>

                        {/*Row 5*/}
                        <Grid item xs={2}></Grid>
                        <Grid item xs={3}>
                            <label>
                                Gradski prevoz:
                                <RadioGroup aria-labelledby="demo-controlled-radio-buttons-group"
                                            name="controlled-radio-buttons-group"
                                            value={valueGP}
                                            onChange={handleChangeGP}
                                >
                                    <FormControlLabel value='0' control={<Radio/>} label="Ima"/>
                                    <FormControlLabel value="1" control={<Radio/>} label="Nema"/>
                                </RadioGroup>
                            </label>
                        </Grid>
                        <Grid item xs={3}>
                            <label>
                                Vodene površine:
                                <RadioGroup aria-labelledby="demo-controlled-radio-buttons-group"
                                            name="controlled-radio-buttons-group"
                                            value={valueVP}
                                            onChange={handleChangeVP}
                                >
                                    <FormControlLabel value='0' control={<Radio/>} label="Ima"/>
                                    <FormControlLabel value="1" control={<Radio/>} label="Nema"/>
                                </RadioGroup>
                            </label>
                        </Grid>
                        <Grid item xs={3}>
                            <label>
                                Skijališta:
                                <RadioGroup aria-labelledby="demo-controlled-radio-buttons-group"
                                            name="controlled-radio-buttons-group"
                                            value={valueSkijalista}
                                            onChange={handleChangeSkijalista}
                                >
                                    <FormControlLabel value='0' control={<Radio/>} label="Ima"/>
                                    <FormControlLabel value="1" control={<Radio/>} label="Nema"/>
                                </RadioGroup>
                            </label>
                        </Grid>

                        <Grid item xs={4}></Grid>
                        <Grid item xs={4}>
                            <Button variant="contained"
                                    onClick={openRec}>
                                Preporuči
                            </Button>
                        </Grid>
                        <Grid item xs={4}></Grid>
                        <br/>
                    </Grid>

                </form>
            </header>

            <SimpleDialog
                open={open}
                onClose={handleClose}
            />
        </div>
    );
}

export default App;

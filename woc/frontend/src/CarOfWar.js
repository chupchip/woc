import React, { Component } from 'react';
import TextField from '@material-ui/core/TextField';

import AppBar from '@material-ui/core/AppBar';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import CssBaseline from '@material-ui/core/CssBaseline';
import Grid from '@material-ui/core/Grid';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import CardActionArea from '@material-ui/core/CardActionArea';

const COURSE_API_URL = 'http://localhost:8080'

class CarOfWar extends Component {
    constructor(props) {
        super(props);
        this.state = {
            carOne: {
                fuelLevel: '',
                ammoStock: '',
                damagingRatio: '',
            },
            carOneVisibility: {
                fuelVisibility: true,
                ammoVisibility: true,
                damagingVisibility: true,
            },
            carTwo: {
                fuelLevel: '',
                ammoStock: '',
                damagingRatio: '',
            },
            carTwoVisibility: {
                fuelVisibility: true,
                ammoVisibility: true,
                damagingVisibility: true,
            }

        }
        this.eventSourceForCarOne = EventSource | undefined;
        this.eventSourceForCarTwo = EventSource | undefined;
    }

    async componentDidMount() {
        this.carOneEventSource();
        this.carTwoEventSource();
    }


    carOneEventSource() {
        const eventSourceForCarOne = new EventSource(`${COURSE_API_URL}/woc/car/carOneStates`);
        eventSourceForCarOne.onopen = (event) => console.log('open', event);
        eventSourceForCarOne.onmessage = (event) => {
            this.setState({
                carOneVisibility: {
                    fuelVisibility: this.state.carOne.fuelLevel === JSON.parse(event.data).fuelLevel ? false : true,
                    ammoVisibility: this.state.carOne.ammoStock === JSON.parse(event.data).ammoStock ? false : true,
                    damagingVisibility: this.state.carOne.damagingRatio === JSON.parse(event.data).damagingRatio ? false : true
                }
            });
            this.setState({
                carOne: {
                    fuelLevel: JSON.parse(event.data).fuelLevel,
                    ammoStock: JSON.parse(event.data).ammoStock,
                    damagingRatio: JSON.parse(event.data).damagingRatio
                }
            });
        };
        eventSourceForCarOne.onerror = (event) => console.log('error', event);
    }

    carTwoEventSource() {
        const eventSourceForCarTwo = new EventSource(`${COURSE_API_URL}/woc/car/carTwoStates`);
        eventSourceForCarTwo.onopen = (event) => console.log('open', event);
        eventSourceForCarTwo.onmessage = (event) => {
            this.setState({
                carTwoVisibility: {
                    fuelVisibility: this.state.carTwo.fuelLevel === JSON.parse(event.data).fuelLevel ? false : true,
                    ammoVisibility: this.state.carTwo.ammoStock === JSON.parse(event.data).ammoStock ? false : true,
                    damagingVisibility: this.state.carTwo.damagingRatio === JSON.parse(event.data).damagingRatio ? false : true
                }
            });
            this.setState({
                carTwo: {
                    fuelLevel: JSON.parse(event.data).fuelLevel,
                    ammoStock: JSON.parse(event.data).ammoStock,
                    damagingRatio: JSON.parse(event.data).damagingRatio
                }
            });
        };
        eventSourceForCarTwo.onerror = (event) => console.log('error', event);
    }

    render() {

        return (
            <React.Fragment>
                <CssBaseline />
                <AppBar position="relative">
                    <Toolbar>
                        <Typography variant="h6" color="inherit" noWrap>
                            ARABA SAVAŞI 
                        </Typography>
                    </Toolbar>
                </AppBar>
                <main>
                    <Grid container spacing={3}>
                        <Grid item xs={6}>
                            <Card className="maxWidth: 20">
                                <CardActionArea>
                                    <CardContent>
                                        <Typography gutterBottom variant="h5" component="h2">
                                            Araç 1
                                     </Typography>
                                        <Grid container spacing={3}>
                                            {this.state.carOneVisibility.fuelVisibility ? <Grid item xs={3}>
                                                <Card >
                                                    <CardContent >
                                                        Yakıt Seviyesi (Lt)
                                                </CardContent>
                                                    <CardActions>
                                                        <TextField
                                                            id="fuelLevelId"
                                                            value={this.state.carOne.fuelLevel}
                                                            InputProps={{
                                                                readOnly: true,
                                                            }}
                                                            variant="outlined"
                                                        />
                                                    </CardActions>
                                                </Card>
                                            </Grid> : null}

                                            {this.state.carOneVisibility.ammoVisibility ? <Grid item xs={3}>
                                                <Card >
                                                    <CardContent >
                                                        Mühimmat Sayısı (Adet)
                                                </CardContent>
                                                    <CardActions>
                                                        <TextField
                                                            id="ammoStockId"
                                                            value={this.state.carOne.ammoStock}
                                                            InputProps={{
                                                                readOnly: true,
                                                            }}
                                                            variant="outlined"
                                                        />
                                                    </CardActions>
                                                </Card>
                                            </Grid> : null}


                                            {this.state.carOneVisibility.damagingVisibility ? <Grid item xs={3}>
                                                <Card >
                                                    <CardContent >
                                                        Hasar Orani (%)
                                                </CardContent>
                                                    <CardActions>
                                                        <TextField
                                                            id="damagingRatioId"
                                                            value={this.state.carOne.damagingRatio}
                                                            InputProps={{
                                                                readOnly: true,
                                                            }}
                                                            variant="outlined"
                                                        />
                                                    </CardActions>
                                                </Card>
                                            </Grid> : null}
                                        </Grid>
                                    </CardContent>
                                </CardActionArea>
                            </Card>
                        </Grid>
                        <Grid item xs={6}>
                            <Card className="maxWidth: 20">
                                <CardActionArea>
                                    <CardContent>
                                        <Typography gutterBottom variant="h5" component="h2">
                                            Araç 2
                                     </Typography>
                                        <Grid container spacing={3}>
                                            {this.state.carTwoVisibility.fuelVisibility ? <Grid item xs={3}>
                                                <Card >
                                                    <CardContent >
                                                        Yakıt Seviyesi (Lt)
                                                </CardContent>
                                                    <CardActions>
                                                        <TextField
                                                            id="fuelLevelId"
                                                            value={this.state.carTwo.fuelLevel}
                                                            InputProps={{
                                                                readOnly: true,
                                                            }}
                                                            variant="outlined"
                                                        />
                                                    </CardActions>
                                                </Card>
                                            </Grid> : null}
                                            {this.state.carTwoVisibility.ammoVisibility ? <Grid item xs={3}>
                                                <Card >
                                                    <CardContent >
                                                        Mühimmat Sayısı (Adet)
                                                </CardContent>
                                                    <CardActions>
                                                        <TextField
                                                            id="ammoStockId"
                                                            value={this.state.carTwo.ammoStock}
                                                            InputProps={{
                                                                readOnly: true,
                                                            }}
                                                            variant="outlined"
                                                        />
                                                    </CardActions>
                                                </Card>
                                            </Grid> : null}
                                            {this.state.carTwoVisibility.damagingVisibility ? <Grid item xs={3}>
                                                <Card >
                                                    <CardContent >
                                                        Hasar Orani (%)
                                                </CardContent>
                                                    <CardActions>
                                                        <TextField
                                                            id="damagingRatioId"
                                                            value={this.state.carTwo.damagingRatio}
                                                            InputProps={{
                                                                readOnly: true,
                                                            }}
                                                            variant="outlined"
                                                        />
                                                    </CardActions>
                                                </Card>
                                            </Grid> : null}
                                        </Grid>
                                    </CardContent>
                                </CardActionArea>
                            </Card>
                        </Grid>
                    </Grid>
                </main>
            </React.Fragment>
        );

    }


}

export default CarOfWar;
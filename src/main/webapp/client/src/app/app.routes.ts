import { Routes } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { PersonComponent } from './person/person.component';
import { HeaterComponent } from './heater/heater.component';
import { ElectronicdeviceComponent } from './electronicdevice/electronicdevice.component';

export const ROUTES: Routes = [
{ path: 'home', component: HomeComponent },
{ path: 'person', component: PersonComponent },
{ path: 'heater', component: HeaterComponent },
{ path: 'electronicdevice', component: ElectronicdeviceComponent },
];

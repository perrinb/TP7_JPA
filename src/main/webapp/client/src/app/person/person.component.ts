import {Component, OnInit, ViewChild} from '@angular/core';
import { Http, Headers } from '@angular/http';
import {ModalDirective} from "ng2-bootstrap";
import {Person} from "./person.model";

@Component({
  selector: 'person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent implements OnInit {

  lastname:any;
  firstname:any;
  email:any;

  filter:Person = new Person();

  persons;
  homes;
  homesChecked:any[] = [];

  @ViewChild('autoShownModal') public autoShownModal:ModalDirective;
  public isModalShown:boolean = false;

  constructor(private http: Http) {
  }

  ngOnInit() {
      this.getPersons();
      this.getHomes();
  }

  public showModal():void {
    this.isModalShown = true;
  }

  public hideModal():void {
    this.autoShownModal.hide();
  }

  public onHidden():void {
    this.isModalShown = false;
  }

  addPerson() {
      var headers = new Headers();
      headers.append('Content-Type', 'application/json');
      this.homes.filter(_ => _.selected).forEach(_ => { this.homesChecked.push({idHome:_.idHome});  });

      var content = JSON.stringify({
        lastname: this.lastname,
        firstname: this.firstname,
        email: this.email,
        homesChecked: this.homesChecked,
      });

      return this.http.put('/rest/person/create', content, {
        headers: headers
      }).map(res => res.json()).subscribe(
        data => { console.log(data); },
        err => { console.log(err); }
      );
  }

  getPersonById(){
    var headers = new Headers();
      headers.append('Content-Type', 'application/json');

      return this.http.get('/rest/person/search/1', {
        headers: headers
      }).map(res => res.json()).subscribe(
        data => { this.persons = data; console.log(data); },
        err => { console.log(err); }
      );
  }

  getPersons(){
      var headers = new Headers();
      headers.append('Content-Type', 'application/json');

      return this.http.get('/rest/person/', {
        headers: headers
      }).map(res => res.json()).subscribe(
        data => { this.persons = data; console.log(data); },
        err => { console.log(err); }
      );
  }

  getHomes(){
      var headers = new Headers();
      headers.append('Content-Type', 'application/json');

      return this.http.get('/rest/home/', {
        headers: headers
      }).map(res => res.json()).subscribe(
        data => { this.homes = data; console.log(data); },
        err => { console.log(err); }
      );
  }
}

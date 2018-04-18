import {Component, OnInit, ViewChild} from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Http, Headers } from '@angular/http';
import {ModalDirective} from "ng2-bootstrap";

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  nbRoom:any;
  size:any;

  homes;

  @ViewChild('autoShownModal') public autoShownModal:ModalDirective;
  public isModalShown:boolean = false;

  constructor(private http: Http) { }

  ngOnInit() {
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


  addHome() {
      var headers = new Headers();
      headers.append('Content-Type', 'application/json');

      var content = JSON.stringify({
        nbRoom: this.nbRoom,
        size: this.size,
      });

      return this.http.put('/rest/home/create', content, {
        headers: headers
      }).map(res => res.json()).subscribe(
        data => { console.log(data); },
        err => { console.log(err); }
      );
  }

  getHomeById(id){
    this.homes = this.http.get('/rest/home/search/'+id);
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

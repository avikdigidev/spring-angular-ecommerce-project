import { Injectable } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from './../common/product';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private baseUrl = 'http://localhost:8588/api-productInfo/products'
 
  constructor(private httpClient: HttpClient) {}

getProductList(): Observable<Object>{
  return this.httpClient.get(this.baseUrl);
  
}
   

}
interface GetResponse{
     products: Product[];
}

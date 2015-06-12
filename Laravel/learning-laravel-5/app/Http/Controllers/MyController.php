<?php namespace App\Http\Controllers;

use Illuminate\Foundation\Bus\DispatchesJobs;
use Illuminate\Routing\Controller as BaseController;
use Illuminate\Foundation\Validation\ValidatesRequests;

class MyController extends BaseController{
  public function contact(){
    return view('pages/contact');
  }

  public function about(){
    $first = 'Meo beo';
    $people = [
      'Bill Gates',
      'Steve Jobs'
    ];
    return view('pages/about', compact('people', 'first'));
  }
}

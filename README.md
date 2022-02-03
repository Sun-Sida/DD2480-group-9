# DD2480-group-9 Assignment 1:Decide

## Program description
Decide is part of a hypthetical anti-ballistic missle system. It generates a boolean signal which determines whether an interceptor should be launched based upon input radar tracking information.

### Requirements

<ul>
	<li>Java JDK 17 </li>
	<li>Java Unit Tests 5.7.2 </li>
	<li>Maven 4.0.0 </li>
</ul>

### How to use:
The function Launch is what generates the YES or NO descision. To use the Launch function you need to create a DECIDE object. To create a DECIDE object, you need to input PARAMETERS object, a Logical Connector Matrix (LCM) and a Preliminary Unlocking Vector (PUV) and the number of points (planar space).  

LCM is a logical connector that is used with CMV to create PUM. It consists of a 15x15 table that is filled with the values ANDD, ORR and NOTUSED.
PUV is a vector that is needed and represents the conditions which have to be met in the final launch decision.
 

## Group: 
Edvard Aldor, Jonathan Hedin, Oscar Ingels, Thea Nöteberg and Sida Sun

### Statement of contributions:

Edvard Aldor
<ul>
	<li>Setting up Maven </li>
	<li>Set up a basic test structure </li>
	<li>Implemented LIC5,6,7 and following test units</li>
</ul>

Jonathan Hedin
<ul>
    <li> Implemented LIC8,9 and 10 and tests for these.</li>
    <li> Corrected issues.</li>
    <li> Verified tests and merged pull requests.</li>
</ul>

Oscar Ingels
<ul>
    <li> Implemented LIC 12, 13, 14 and their test cases.</li>
    <li> Merged pull request.</li>
    <li> Worked on  way of working.</li>
</ul>

Thea Nöteberg
<ul>
    	<li> Implemented LIC 4, 11 and their test cases.</li>
	<li> Implemented unit tests for LIC 0-1 </li>
    	<li> Merged pull request.</li>
    	<li> Created parameters class</li>
	<li> Implemented CMV, PMV, PUV and their unit tests</li>
</ul>
Sida Sun
<ul>
	<li>Set up a base structure of Decide </li>
	<li>Implemented and worked on LIC0-3 </li>
</ul>

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
# DD2480-group-9






# Way of working

Early on it was decided that each LIC became its own issue and was distributed between the group members. Sida took it upon himself to set up some base code to work from, Edvard constructed the build tool and Thea further developed the parameters that where used in testing and methods. Each pull request was reviewed by one other person. We said early on that we would set up a system so that one person always reviews the same persons pull requests - but due to how our working sessions developed, and our difference in knowledge when it came to git, this specific practice was not followed. We have agreed on how meetings should be done and when, and hopefully they will remain well structured in the future.

Perhaps our agreement on some formalities could have been enforced, such as how commit messages should be formatted, who should be the leader of every meeting and what is expected of each other when it comes to the workload.

In summary, there are some principles and foundations established which are in use - but these could be further explored. There are things that could be further developed within the team, but we are on our way to develop a functioning working environment. Some of the kinks that became apparent when doing this assigment will be discussed and hopefully worked on when starting on the second assignment in order for us to work well together.
